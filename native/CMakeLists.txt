cmake_minimum_required(VERSION 3.20)
project(noesis_jni LANGUAGES CXX)

# C++ стандарт
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_POSITION_INDEPENDENT_CODE ON)

# Определение платформы
if (WIN32)
    set(PLATFORM_NAME "windows")
    set(LIB_EXT ".dll")
    set(LIB_PREFIX "") # Noesis.dll (без lib)
elseif (APPLE)
    set(PLATFORM_NAME "macos")
    set(LIB_EXT ".dylib")
    set(LIB_PREFIX "") # Обычно на Mac фреймворки или dylib тоже могут быть без lib, но проверим ниже
elseif (UNIX AND NOT APPLE)
    set(PLATFORM_NAME "linux")
    set(LIB_EXT ".so")
    set(LIB_PREFIX "lib")
else()
    message(FATAL_ERROR "Unsupported platform")
endif()

# Определение архитектуры
if (CMAKE_SYSTEM_PROCESSOR MATCHES "arm" OR CMAKE_SYSTEM_PROCESSOR MATCHES "aarch64")
    set(ARCH_NAME "arm64")
    # Для Mac часто SDK лежит просто в macos, для Windows/Linux - с суффиксом
    if (APPLE)
         set(NOESIS_ARCH_DIR "macos") 
    else()
         set(NOESIS_ARCH_DIR "${PLATFORM_NAME}_arm64")
    endif()
else()
    set(ARCH_NAME "x86_64")
    if (APPLE)
         set(NOESIS_ARCH_DIR "macos")
    else()
         set(NOESIS_ARCH_DIR "${PLATFORM_NAME}_x86_64")
    endif()
endif()

message(STATUS "Configuring for ${PLATFORM_NAME} (${ARCH_NAME}) -> SDK Path: ${NOESIS_ARCH_DIR}")

# ====== ПУТИ ВВОДА/ВЫВОДА ======

# Выходная директория меняется в зависимости от платформы, чтобы не валить всё в win64
set(NATIVE_OUT_DIR "${CMAKE_CURRENT_SOURCE_DIR}/../java/src/main/resources/native/${PLATFORM_NAME}")

# Путь к Noesis SDK (можно передать через -DNOESIS_SDK_DIR=...)
set(NOESIS_SDK_DIR "${CMAKE_SOURCE_DIR}/NoesisSDK" CACHE PATH "Path to Noesis SDK")

# Поиск Java и JNI (автоматически, без хардкода JAVA_HOME)
find_package(JNI REQUIRED)

# Проверяем структуру SDK
if (NOT EXISTS "${NOESIS_SDK_DIR}/Include")
    message(FATAL_ERROR "NOESIS_SDK_DIR (${NOESIS_SDK_DIR}) is wrong: Include/ not found")
endif()

# Устанавливаем пути к бинарникам Noesis
set(NOESIS_BIN_DIR "${NOESIS_SDK_DIR}/Bin/${NOESIS_ARCH_DIR}")

if (APPLE OR UNIX)
    # На Mac библиотека лежит в Bin, а не в Lib
    set(NOESIS_LIB_DIR "${NOESIS_SDK_DIR}/Bin/${NOESIS_ARCH_DIR}")
else()
    # Для Windows и Linux (если ты скопировал .so в Lib) оставляем как было
    set(NOESIS_LIB_DIR "${NOESIS_SDK_DIR}/Lib/${NOESIS_ARCH_DIR}")
endif()

if (NOT EXISTS "${NOESIS_LIB_DIR}")
    message(WARNING "Noesis Lib directory not found at: ${NOESIS_LIB_DIR}. Check your SDK structure.")
endif()

set(PACKAGES_DIR "${NOESIS_SDK_DIR}/Packages")

# ====== INCLUDE ======
include_directories(
        ${NOESIS_SDK_DIR}/Include
        ${JNI_INCLUDE_DIRS}
        
        # ВАЖНО: Добавляем корень Packages, чтобы работали пути вида <App/Theme/...>
        ${PACKAGES_DIR}

        # Явное добавление путей к компонентам Noesis App Framework (для путей вида <NsApp/...>)
        ${PACKAGES_DIR}/App/ApplicationLauncher/Include
        ${PACKAGES_DIR}/App/Theme/Include                 # <-- БЫЛО ПРОПУЩЕНО
        ${PACKAGES_DIR}/App/Display/Include
        ${PACKAGES_DIR}/App/DisplayLauncher/Include
        ${PACKAGES_DIR}/App/Interactivity/Include
        ${PACKAGES_DIR}/App/MediaElement/Include
        ${PACKAGES_DIR}/App/Providers/Include
        ${PACKAGES_DIR}/App/Rive/Include
        ${PACKAGES_DIR}/App/RiveBase/Include
        ${PACKAGES_DIR}/App/Shaders/Include
        ${PACKAGES_DIR}/App/LangServer/Include
        ${PACKAGES_DIR}/App/LangServerHelpers/Include
        ${PACKAGES_DIR}/App/Launcher/Include
        
        # Рендер
        ${PACKAGES_DIR}/Render/RenderContext/Include
        ${PACKAGES_DIR}/Render/GLRenderContext/Include
        ${PACKAGES_DIR}/Render/GLRenderDevice/Include    # <-- БЫЛО ПРОПУЩЕНО (нужно для GLFactory.h)
)

if (WIN32)
    include_directories(${JAVA_HOME}/include/win32)
elseif (APPLE)
    include_directories(${JAVA_HOME}/include/darwin)
else()
    include_directories(${JAVA_HOME}/include/linux)
endif()

# ====== ИСХОДНИКИ ======
add_library(noesis_jni SHARED
        src/NsDrawing/NSColorJni.cpp
        src/NsDrawing/NSCornerRadiusJni.cpp
        src/NsDrawing/NSInt32RectJni.cpp
        src/utils/NSJniUtils.cpp
        src/utils/NSJniUtils.h
        src/NsCore/NsSymbolJni.cpp
        src/NsCore/NsTypeJni.cpp
        src/NsCore/NsBaseComponentJni.cpp
        src/NsRender/NsRenderTargetJni.cpp
        src/NsRender/NsRenderDeviceJni.cpp
        src/Debug/NSDebugCpp.cpp
        src/NsApp/NsXamlProviderJni.cpp
        src/NsCore/NsStreamJni.cpp
        src/NsCore/NsDispatcherObjectJni.cpp
        src/NsCore/NsBaseObjectJni.cpp
        src/NsCore/NsBaseRefCountedJni.cpp
        src/NsCore/NsDependencyPropertyJni.cpp
        src/NsGui/NsVisualJni.cpp
        src/NsGui/NsUIElementJni.cpp
        src/NSNoesisGuiJni.cpp
        src/NsCore/NsInterfaceJni.cpp
        src/NsGui/NsIRendererJni.cpp
        src/NsGui/NSIViewJni.cpp
        src/Render/NsRenderContextJni.cpp
        src/Render/NsGLJni.cpp
        src/NsApp/NsThemeJni.cpp
        src/NsGui/NsFrameworkElementJni.cpp
        src/jni.cpp
        src/events/NsWidgetEvents.h
        src/jni.h
        src/NsCore/NsRoutedEventJni.cpp
        src/events/NsButtonEventJni.cpp
        src/events/NsFrameworkElementEventsJni.cpp
        src/utils/NSJavaUtils.h
        src/events/NsFrameworkElementEventsJni.cpp
        src/events/NsUIElementEventsJni.cpp
        src/NsGui/NsControlJni.cpp
        src/NsGui/NsContentControlJni.cpp
        src/NsGui/NSItemContainerGeneratorJni.cpp
        src/NsGui/NSPanelJni.cpp
        src/NsGui/NSGridJni.cpp
        src/NsGui/NSBaseButtonJni.cpp
        src/NsGui/NSBrushJni.cpp
        src/NsGui/NSSolidColorBrushJni.cpp
        src/NsGui/NSBrushesJni.cpp
        src/NsGui/NSGradientBrushJni.cpp
        src/NsGui/NSLinearGradientBrushJni.cpp
        src/NsGui/NSRadialGradientBrushJni.cpp
        src/NsGui/NSTileBrushJni.cpp
        src/NsGui/NSVisualBrushJni.cpp
        src/NsGui/NSImageBrushJni.cpp
        src/Render/NSGLRenderUtil.h
        NoesisSDK/Packages/Render/GLRenderContext/Src/GLRenderContext.h
        NoesisSDK/Packages/Render/GLRenderDevice/Src/GLRenderDevice.cpp
        src/NsGui/NSGradientStopCollectionJni.cpp
        src/NsGui/NSGradientStopJni.cpp
        src/NsGui/NSButtonJni.cpp
        src/NsGui/NSUIElementCollectionJni.cpp
        src/NsGui/NSToggleButtonJni.cpp
        src/NsGui/NSRadioButtonJni.cpp
        src/NsGui/NSCheckBoxJni.cpp
        src/NsGui/NSRepeatButtonJni.cpp
        src/NsGui/NSGridViewColumnHeaderJni.cpp
        src/NsGui/NSToolTipJni.cpp
        src/NsGui/NSLabelJni.cpp
        src/NsGui/NSUserControlJni.cpp
        src/NsGui/NSPageJni.cpp
        src/NsGui/NSStatusBarItemJni.cpp
        src/NsGui/NSBaseTextBoxJni.cpp
        src/NsGui/NSTypographyJni.cpp
        src/NsGui/NSTextBoxJni.cpp
        src/NsGui/NSRangeBaseJni.cpp
        src/NsGui/NSSliderJni.cpp
        src/NsGui/NSProgressBarJni.cpp
        src/NsGui/NSScrollBarJni.cpp
        src/NsGui/NSTextBlockJni.cpp
        src/NsGui/NSPasswordBoxJni.cpp
        src/NsGui/NSTextElementJni.cpp
        src/NsGui/NSInlineJni.cpp
        src/NsGui/NSSpanJni.cpp
        src/NsGui/NSItalicJni.cpp
        src/NsGui/NSBoldJni.cpp
        src/NsGui/NSUnderlineJni.cpp
        src/NsGui/NSHyperlinkJni.cpp
        src/NsGui/NSInlineCollectionJni.cpp
        src/NsGui/NSColumnDefinitionCollectionJni.cpp
        src/NsGui/NSCommandBindingCollectionJni.cpp
        src/NsGui/NSInputBindingCollectionJni.cpp
        src/NsGui/NSRowDefinitionCollectionJni.cpp
        src/NsGui/NSTriggerCollectionJni.cpp
        src/NsGui/NSRunJni.cpp
        src/NsGui/NSInlineUIContainerJni.cpp
        src/NsGui/NSLineBreakJni.cpp
        src/NsGui/NSItemsControlJni.cpp
        src/NsGui/NSTreeViewJni.cpp
        src/NsGui/NSContextMenuJni.cpp
        src/NsGui/NSMenuJni.cpp
        src/NsGui/NSToolBarOverflowPanelJni.cpp
        src/NsGui/NSCanvasJni.cpp
        src/NsGui/NSStackPanelJni.cpp
        src/NsGui/NSToolBarPanelJni.cpp
        src/NsGui/NSUniformGridJni.cpp
        src/NsGui/NSDockPanelJni.cpp
        src/NsGui/NSWrapPanelJni.cpp
        src/NsGui/NSTabPanelJni.cpp
        src/NsGui/NSVirtualizingStackPanelJni.cpp
        src/NsGui/NSVirtualizingWrapPanelJni.cpp
        NoesisSDK/Packages/App/ApplicationLauncher/Include/NsApp/NotifyPropertyChangedBase.h
        NoesisSDK/Packages/App/ApplicationLauncher/Include/NsApp/ApplicationLauncherApi.h
        src/NsApp/JavaNotifyPropertyChangedBase.cpp
        src/NsApp/JavaNotifyPropertyChangedBase.h
        src/NsApp/NsNotifyPropertyChangedBaseJni.cpp
        NoesisSDK/Packages/App/Display/Include/NsApp/Display.h
        NoesisSDK/Packages/App/DisplayLauncher/Include/NsApp/DisplayLauncher.h
        NoesisSDK/Packages/App/DisplayLauncher/Include/NsApp/DisplayLauncherApi.h
        NoesisSDK/Packages/App/ApplicationLauncher/Include/NsApp/Application.h
        NoesisSDK/Packages/App/ApplicationLauncher/Include/NsApp/ApplicationLauncher.h
        NoesisSDK/Packages/App/ApplicationLauncher/Include/NsApp/DelegateCommand.h
        NoesisSDK/Packages/App/ApplicationLauncher/Include/NsApp/LocExtension.h
        NoesisSDK/Packages/App/ApplicationLauncher/Include/NsApp/MessageBox.h
        NoesisSDK/Packages/App/ApplicationLauncher/Include/NsApp/RichText.h
        NoesisSDK/Packages/App/ApplicationLauncher/Include/NsApp/Window.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/AttachableCollection.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/AttachableCollection.inl
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/AttachableObject.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/BackgroundEffectBehavior.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/Behavior.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/BehaviorCollection.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/ChangePropertyAction.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/CollectionFilterBehavior.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/CollectionSortBehavior.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/ComparisonCondition.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/ConditionalExpression.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/ConditionBehavior.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/ControlStoryboardAction.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/DataEventTrigger.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/DataTrigger.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/EventTrigger.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/EventTriggerBase.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/FilterPredicate.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/GamepadTrigger.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/GoToStateAction.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/IAttachedObject.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/Interaction.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/InteractivityApi.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/InvokeCommandAction.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/KeyTrigger.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/LaunchUriOrFileAction.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/LineDecorationBehavior.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/LoadContentAction.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/MediaActions.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/MouseDragElementBehavior.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/MoveFocusAction.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/PlaySoundAction.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/PropertyChangedTrigger.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/RemoveElementAction.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/SelectAction.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/SelectAllAction.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/SetFocusAction.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/SortComparer.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/StoryboardAction.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/StoryboardCompletedTrigger.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/StoryboardTrigger.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/StringFilterPredicate.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/StringSortComparer.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/StyleInteraction.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/TargetedTriggerAction.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/TimerTrigger.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/TranslateZoomRotateBehavior.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/TriggerAction.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/TriggerActionCollection.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/TriggerBase.h
        NoesisSDK/Packages/App/Interactivity/Include/NsApp/TriggerCollection.h
        NoesisSDK/Packages/App/Providers/Include/NsApp/EmbeddedFontProvider.h
        NoesisSDK/Packages/App/Providers/Include/NsApp/EmbeddedTextureProvider.h
        NoesisSDK/Packages/App/Providers/Include/NsApp/EmbeddedXamlProvider.h
        NoesisSDK/Packages/App/Providers/Include/NsApp/FastLZ.h
        NoesisSDK/Packages/App/Providers/Include/NsApp/FileSystemWatcher.h
        NoesisSDK/Packages/App/Providers/Include/NsApp/FileTextureProvider.h
        NoesisSDK/Packages/App/Providers/Include/NsApp/Find.h
        NoesisSDK/Packages/App/Providers/Include/NsApp/LocalFontProvider.h
        NoesisSDK/Packages/App/Providers/Include/NsApp/LocalTextureProvider.h
        NoesisSDK/Packages/App/Providers/Include/NsApp/LocalXamlProvider.h
        NoesisSDK/Packages/App/Providers/Include/NsApp/ProvidersApi.h
        NoesisSDK/Packages/App/Rive/Include/NsApp/RiveApi.h
        NoesisSDK/Packages/App/Rive/Include/NsApp/RiveTriggerAction.h
        NoesisSDK/Packages/App/RiveBase/Include/NsApp/RiveBaseApi.h
        NoesisSDK/Packages/App/RiveBase/Include/NsApp/RiveControl.h
        NoesisSDK/Packages/App/RiveBase/Include/NsApp/RiveInput.h
        NoesisSDK/Packages/App/RiveBase/Include/NsApp/RiveRun.h
        NoesisSDK/Packages/App/Shaders/Include/NsApp/BoxShadow.h
        NoesisSDK/Packages/App/Shaders/Include/NsApp/ConicGradientBrush.h
        NoesisSDK/Packages/App/Shaders/Include/NsApp/CrossFadeBrush.h
        NoesisSDK/Packages/App/Shaders/Include/NsApp/DirectionalBlurEffect.h
        NoesisSDK/Packages/App/Shaders/Include/NsApp/MonochromeBrush.h
        NoesisSDK/Packages/App/Shaders/Include/NsApp/PinchEffect.h
        NoesisSDK/Packages/App/Shaders/Include/NsApp/PixelateEffect.h
        NoesisSDK/Packages/App/Shaders/Include/NsApp/PlasmaBrush.h
        NoesisSDK/Packages/App/Shaders/Include/NsApp/SaturationEffect.h
        NoesisSDK/Packages/App/Shaders/Include/NsApp/ShadersApi.h
        NoesisSDK/Packages/App/Shaders/Include/NsApp/TintEffect.h
        NoesisSDK/Packages/App/Shaders/Include/NsApp/VignetteEffect.h
        NoesisSDK/Packages/App/Shaders/Include/NsApp/WavesBrush.h
        NoesisSDK/Packages/App/Display/Include/NsApp/DisplayApi.h
        NoesisSDK/Packages/App/MediaElement/Include/NsApp/MediaElement.h
        NoesisSDK/Packages/App/MediaElement/Include/NsApp/MediaElementApi.h
        NoesisSDK/Packages/App/MediaElement/Include/NsApp/MediaPlayer.h
        NoesisSDK/Packages/App/LangServer/Include/NsApp/LangServer.h
        NoesisSDK/Packages/App/LangServer/Include/NsApp/LangServerApi.h
        NoesisSDK/Packages/App/LangServerHelpers/Include/NsApp/LangServerHelpersApi.h
        NoesisSDK/Packages/App/LangServerHelpers/Include/NsApp/PreviewRenderer.h
        NoesisSDK/Packages/App/Launcher/Include/NsApp/CommandLine.h
        NoesisSDK/Packages/App/Launcher/Include/NsApp/EntryPoint.h
        NoesisSDK/Packages/Render/RenderContext/Include/NsRender/Image.h
        src/NsGui/NSThumbJni.cpp
        src/NsGui/NSGridSplitterJni.cpp
        src/NsGui/NSSelectorJni.cpp
        src/NsGui/NSComboBoxJni.cpp
        src/NsGui/NSTabControlJni.cpp
        src/NsGui/NSSelectedItemsCollectionJni.cpp
        src/NsGui/NSListBoxJni.cpp
        src/NsGui/NSListViewJni.cpp
        src/providers/JniXamlProvider.cpp
        src/providers/JniXamlProvider.h
        src/providers/JniXamlProviderUtils.h
        src/providers/JniXamlProviderUtils.cpp
)

target_link_directories(noesis_jni PRIVATE ${NOESIS_LIB_DIR})

if (WIN32)
    set(LIB_NOESIS_NAME "Noesis.lib")
    set(LIB_NOESIS_APP_NAME "NoesisApp.lib")
elseif (APPLE)
    set(LIB_NOESIS_NAME "Noesis.dylib")
    set(LIB_NOESIS_APP_NAME "NoesisApp.dylib")
else() # Linux
    set(LIB_NOESIS_NAME "libNoesis.so")
    set(LIB_NOESIS_APP_NAME "libNoesisApp.so")
endif()

target_link_libraries(noesis_jni
    "${NOESIS_LIB_DIR}/${LIB_NOESIS_NAME}"
    "${NOESIS_LIB_DIR}/${LIB_NOESIS_APP_NAME}"
)

# ====== КОПИРОВАНИЕ ЗАВИСИМОСТЕЙ ======
# Копируем .dll / .so / .dylib рядом с результатом сборки и в resources
# Используем генераторные выражения для кроссплатформенности

add_custom_command(TARGET noesis_jni POST_BUILD
        # Создаем папку назначения (resources/native/PLATFORM)
        COMMAND ${CMAKE_COMMAND} -E make_directory "${NATIVE_OUT_DIR}"
        
        # Копируем саму библиотеку JNI
        COMMAND ${CMAKE_COMMAND} -E copy_if_different
        "$<TARGET_FILE:noesis_jni>"
        "${NATIVE_OUT_DIR}/$<TARGET_FILE_NAME:noesis_jni>"

        # Копируем Noesis SDK shared libs
        COMMAND ${CMAKE_COMMAND} -E copy_if_different
        "${NOESIS_BIN_DIR}/${LIB_PREFIX}Noesis${LIB_EXT}"
        "${NATIVE_OUT_DIR}/${LIB_PREFIX}Noesis${LIB_EXT}"
        
        COMMAND ${CMAKE_COMMAND} -E copy_if_different
        "${NOESIS_BIN_DIR}/${LIB_PREFIX}NoesisApp${LIB_EXT}"
        "${NATIVE_OUT_DIR}/${LIB_PREFIX}NoesisApp${LIB_EXT}"
)

# Настройка свойств таргета
set_target_properties(noesis_jni PROPERTIES
        OUTPUT_NAME "noesis_jni"
        RUNTIME_OUTPUT_DIRECTORY "${NATIVE_OUT_DIR}"
)

# Поддержка IDE с мультиконфигурацией (VS, Xcode)
foreach(cfg IN LISTS CMAKE_CONFIGURATION_TYPES)
    string(TOUPPER "${cfg}" CFG_UPPER)
    set_target_properties(noesis_jni PROPERTIES
            RUNTIME_OUTPUT_DIRECTORY_${CFG_UPPER} "${NATIVE_OUT_DIR}"
    )
endforeach()