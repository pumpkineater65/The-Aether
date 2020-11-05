package com.legacy.aether.util;

import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import net.minecraft.screen.ScreenHandler;

public class Reflection {

    public static <T> void setField(Class<T> clazz, T instance, int fieldNumber, Object obj) {
        try {
            Field field = FieldUtils.getAllFields(ScreenHandler.class)[fieldNumber];

            field.setAccessible(true);

            field.set(instance, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}