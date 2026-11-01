class EnumOptionsMappingHelper {
   static final int[] a = new int[EnumOptions.values().length];

   static {
      try {
         a[EnumOptions.c.ordinal()] = 1;
      } catch (NoSuchFieldError var7) {
      }

      try {
         a[EnumOptions.h.ordinal()] = 2;
      } catch (NoSuchFieldError var6) {
      }

      try {
         a[EnumOptions.i.ordinal()] = 3;
      } catch (NoSuchFieldError var5) {
      }

      try {
         a[EnumOptions.j.ordinal()] = 4;
      } catch (NoSuchFieldError var4) {
      }

      try {
         a[EnumOptions.n.ordinal()] = 5;
      } catch (NoSuchFieldError var3) {
      }

      try {
         a[EnumOptions.p.ordinal()] = 6;
      } catch (NoSuchFieldError var2) {
      }

      try {
         a[EnumOptions.STRIPELANDSFIX.ordinal()] = 7;
      } catch (NoSuchFieldError var1) {
      }
   }
}
