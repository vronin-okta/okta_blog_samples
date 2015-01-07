package com.example.vronin.testapp;

/**
 * Created by vronin on 1/6/15.
 */
import java.lang.reflect.Field;
import javax.inject.Inject;

public class InjectHelper {

    @SuppressWarnings("unchecked")
    public static void injectMock(Object target, Object mock)
    {
        Class targetClass = target.getClass();
        do {
            Field[] fields = targetClass.getDeclaredFields();
            // Iterate through all members
            for (Field field : fields) {
                // Skip all non injectable members
                if (field.getAnnotation(Inject.class) == null)
                    continue;

                // Make private/prptected members accessible
                field.setAccessible(true);

                // Get a class of the member
                Class injectedClass = field.getType();
                Class mockClass = mock.getClass();

                // Check that mock is essentially the same class
                if (!injectedClass.isAssignableFrom(mockClass))
                    continue;

                try {
                    // Inject mock
                    field.set(target, mock);
                } catch (IllegalAccessException e)
                {
                    throw new RuntimeException(e);
                }

                // return accessibility
                field.setAccessible(false);
            }
            targetClass = targetClass.getSuperclass();
        }
        while (targetClass != null && targetClass != Object.class);
    }
}
