package com.niocoder.niocoder.Enum;

public enum  AnimalEnum {
    ANIMAL_CAT("1","animalCat"),
    ANIMAL_DOG("2","animalDog"),
    ANIMAL_SHEEP("3","animalSheep"),
    ;

    private String code;
    private String name;

    AnimalEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
    public static AnimalEnum codeOf(String code) {
        for (AnimalEnum var : AnimalEnum.values()) {
            if (var.getCode().equals(code)) {
                return var;
            }
        }
        return null;
    }

    public static String getId(String name) {
        AnimalEnum[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            AnimalEnum os = var1[var3];
            if (os.getName().equalsIgnoreCase(name)) {
                return os.code;
            }
        }

        return null;
    }

    public static String getName(String code) {
        if (code != null) {
            AnimalEnum[] var1 = values();
            int var2 = var1.length;

            for (int var3 = 0; var3 < var2; ++var3) {
                AnimalEnum os = var1[var3];
                if (os.getCode().equals(code)) {
                    return os.name;
                }
            }
        }

        return null;
    }

}
