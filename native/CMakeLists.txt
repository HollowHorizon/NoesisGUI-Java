cmake_minimum_required(VERSION 3.20)
project(noesis_jni LANGUAGES CXX)

# C++ стандарт
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_POSITION_INDEPENDENT_CODE ON)



set(NOESIS_SDK_DIR "${CMAKE_SOURCE_DIR}/NoesisSDK" CACHE PATH "Local Noesis SDK")
set(JAVA_HOME "C:/Program Files/Java/jdk-21" CACHE PATH "Path to JDK 21")

# ====== НАСТРОЙКИ ПУТЕЙ ======

# Проверяем, что есть include
if (NOT EXISTS "${NOESIS_SDK_DIR}/Include")
    message(FATAL_ERROR "NOESIS_SDK_DIR (${NOESIS_SDK_DIR}) is wrong: Include/ not found")
endif()

# Проверяем, что есть jni.h
if (NOT EXISTS "${JAVA_HOME}/include/jni.h")
    message(FATAL_ERROR "JAVA_HOME (${JAVA_HOME}) is wrong: include/jni.h not found")
endif()

# Пути к JNI и Noesis headers
include_directories(
        ${NOESIS_SDK_DIR}/Include
        ${JAVA_HOME}/include
)

if (WIN32)
    include_directories(${JAVA_HOME}/include/win32)
else()
    include_directories(${JAVA_HOME}/include/linux)
endif()

# Выбираем нужные подпапки для x64 Windows
if (WIN32 AND CMAKE_SIZEOF_VOID_P EQUAL 8)
    set(NOESIS_BIN_DIR "${NOESIS_SDK_DIR}/Bin/windows_x86_64")
    set(NOESIS_LIB_DIR "${NOESIS_SDK_DIR}/Lib/windows_x86_64") # <-- проверь, что такая папка есть
endif()

add_library(noesis_jni SHARED
        src/NsDrawing/NSColorJni.cpp
)

# Линкуемся по .lib
if (NOESIS_LIB_DIR)
    target_link_directories(noesis_jni PRIVATE
            ${NOESIS_LIB_DIR}
    )
endif()

target_link_libraries(noesis_jni
        Noesis         # Noesis.lib
        NoesisApp      # NoesisApp.lib (если используешь App API)
)

# После сборки копируем DLL рядом с noesis_jni.dll
if (NOESIS_BIN_DIR)
    add_custom_command(TARGET noesis_jni POST_BUILD
            COMMAND ${CMAKE_COMMAND} -E copy_if_different
            "${NOESIS_BIN_DIR}/Noesis.dll"
            "$<TARGET_FILE_DIR:noesis_jni>/Noesis.dll"
            COMMAND ${CMAKE_COMMAND} -E copy_if_different
            "${NOESIS_BIN_DIR}/NoesisApp.dll"
            "$<TARGET_FILE_DIR:noesis_jni>/NoesisApp.dll"
    )
endif()

set_target_properties(noesis_jni PROPERTIES
        OUTPUT_NAME "noesis_jni"
)