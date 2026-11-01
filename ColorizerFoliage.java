public class ColorizerFoliage {
   private static int[] a = new int[65536];

   public static void a(int[] par0ArrayOfInteger) {
      a = par0ArrayOfInteger;
   }

   public static int a(double par0, double par2) {
      par2 *= par0;
      int i = (int)((1.0 - par0) * 255.0);
      int j = (int)((1.0 - par2) * 255.0);
      return a[j << 8 | i];
   }

   public static int a() {
      return 6396257;
   }

   public static int b() {
      return 8431445;
   }

   public static int c() {
      return 4764952;
   }
}
