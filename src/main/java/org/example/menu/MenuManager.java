package org.example.menu;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class MenuManager {
    private static final Map<Class<?>, Menu> map = new HashMap<>();

    private static boolean menuExists(Class<?> c) {
        return map.get(c) != null;
    }

    public static Menu getMenu(Class<? extends Menu> menuType) {
        if (menuExists(menuType)) {
            return map.get(menuType);
        }

        var newMenu = createMenu(menuType);
        map.put(menuType, newMenu);

        return newMenu;
    }

    private static Menu createMenu(Class<? extends Menu> menuType) {
        Menu newMenu;

        try {
            newMenu = menuType.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e.getMessage());
        }

        return newMenu;
    }
}
