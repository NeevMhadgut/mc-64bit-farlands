import java.util.Random;

public class MathHelper {
   private static float[] a = new float[65536];

   public static final float a(float par0) {
      return a[(int)(par0 * 10430.38F) & 65535];
   }

   public static final float b(float par0) {
      return a[(int)(par0 * 10430.38F + 16384.0F) & 65535];
   }

   public static final float c(float par0) {
      return (float)Math.sqrt(par0);
   }

   public static final float a(double par0) {
      return (float)Math.sqrt(par0);
   }

   public static int d(float par0) {
      int i = (int)par0;
      return par0 >= i ? i : i - 1;
   }

   public static int b(double par0) {
      return (int)(par0 + 1024.0) - 1024;
   }

   public static int c(double par0) {
      int i = (int)par0;
      return par0 >= i ? i : i - 1;
   }

   public static long d(double par0) {
      long l = (long)par0;
      return par0 >= l ? l : l - 1L;
   }

   public static float e(float par0) {
      return par0 < 0.0F ? -par0 : par0;
   }

   public static int a(int par0, int par1, int par2) {
      if (par0 < par1) {
         return par1;
      } else {
         return par0 > par2 ? par2 : par0;
      }
   }

   public static float a(float par0, float par1, float par2) {
      if (par0 < par1) {
         return par1;
      } else {
         return par0 > par2 ? par2 : par0;
      }
   }

   public static double a(double par0, double par2) {
      if (par0 < 0.0) {
         par0 = -par0;
      }

      if (par2 < 0.0) {
         par2 = -par2;
      }

      return par0 <= par2 ? par2 : par0;
   }

   public static int a(int par0, int par1) {
      return par0 < 0 ? -((-par0 - 1) / par1) - 1 : par0 / par1;
   }

   public static long bucketLong(long par0, long par1) {
      return par0 < 0L ? -((-par0 - 1L) / par1) - 1L : par0 / par1;
   }

   public static boolean a(String par0Str) {
      return par0Str == null || par0Str.length() == 0;
   }

   public static int a(Random par0Random, int par1, int par2) {
      return par1 >= par2 ? par1 : par0Random.nextInt(par2 - par1 + 1) + par1;
   }

   static {
      for (int i = 0; i < 65536; i++) {
         a[i] = (float)Math.sin(i * Math.PI * 2.0 / 65536.0);
      }
   }
}
