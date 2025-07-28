package com.peng.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/28 11:24
 * @Desc:
 */
public class PengImportSelect implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        List<String> list = new ArrayList<>();
        list.add("com.peng.config.WebServerAutoConfiguration");

        return list.toArray(new String[0]);
    }
}
