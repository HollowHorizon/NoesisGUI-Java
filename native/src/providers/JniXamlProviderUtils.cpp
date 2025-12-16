//
// Created by Sixik on 16.12.2025.
//

#include "JniXamlProviderUtils.h"

namespace NoesisJava {

    std::mutex JniXamlProviderUtils::g_xamlCacheMutex;

    std::unordered_map<std::string,
        std::shared_ptr<std::vector<uint8_t>>> JniXamlProviderUtils::g_xamlCache;

    jobject JniXamlProviderUtils::g_xamlLoaderGlobal = nullptr;

    jmethodID JniXamlProviderUtils::g_midLoadXaml = nullptr;

} // namespace NoesisJava
