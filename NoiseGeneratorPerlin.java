import java.util.Random;

public class NoiseGeneratorPerlin extends cp {
   private int[] d = new int[512];
   public double a;
   public double b;
   public double c;

   public NoiseGeneratorPerlin() {
      this(new Random());
   }

   public NoiseGeneratorPerlin(Random par1Random) {
      this.a = par1Random.nextDouble() * 256.0;
      this.b = par1Random.nextDouble() * 256.0;
      this.c = par1Random.nextDouble() * 256.0;
      int i = 0;

      while (i < 256) {
         this.d[i] = i++;
      }

      for (int j = 0; j < 256; j++) {
         int k = par1Random.nextInt(256 - j) + j;
         int l = this.d[j];
         this.d[j] = this.d[k];
         this.d[k] = l;
         this.d[j + 256] = this.d[j];
      }
   }

   public final double a(double par1, double par3, double par5) {
      return par3 + par1 * (par5 - par3);
   }

   public final double a(int par1, double par2, double par4) {
      int i = par1 & 15;
      double d = (1 - ((i & 8) >> 3)) * par2;
      double d1 = i >= 4 ? (i != 12 && i != 14 ? par4 : par2) : 0.0;
      return ((i & 1) != 0 ? -d : d) + ((i & 2) != 0 ? -d1 : d1);
   }

   public final double a(int par1, double par2, double par4, double par6) {
      int i = par1 & 15;
      double d = i >= 8 ? par4 : par2;
      double d1 = i >= 4 ? (i != 12 && i != 14 ? par6 : par2) : par4;
      return ((i & 1) != 0 ? -d : d) + ((i & 2) != 0 ? -d1 : d1);
   }

   public void a(
      double[] par1ArrayOfDouble, double par2, double par4, double par6, int par8, int par9, int par10, double par11, double par13, double par15, double par17
   ) {
      if (par9 == 1) {
         boolean flag = false;
         boolean flag1 = false;
         boolean flag2 = false;
         boolean flag3 = false;
         double d1 = 0.0;
         double d3 = 0.0;
         int k2 = 0;
         double d5 = 1.0 / par17;

         for (int j3 = 0; j3 < par8; j3++) {
            double d7 = par2 + j3 * par11 + this.a;
            long k3 = (long)d7;
            if (d7 < k3) {
               k3--;
            }

            int l3 = (int)(k3 & 255L);
            d7 -= k3;
            double d10 = d7 * d7 * d7 * (d7 * (d7 * 6.0 - 15.0) + 10.0);

            for (int i4 = 0; i4 < par10; i4++) {
               double d12 = par6 + i4 * par15 + this.c;
               long k4 = (long)d12;
               if (d12 < k4) {
                  k4--;
               }

               int i5 = (int)(k4 & 255L);
               d12 -= k4;
               double d14 = d12 * d12 * d12 * (d12 * (d12 * 6.0 - 15.0) + 10.0);
               int i = this.d[l3] + 0;
               int k = this.d[i] + i5;
               int l = this.d[l3 + 1] + 0;
               int i1 = this.d[l] + i5;
               double d2 = this.a(d10, this.a(this.d[k], d7, d12), this.a(this.d[i1], d7 - 1.0, 0.0, d12));
               double d4 = this.a(d10, this.a(this.d[k + 1], d7, 0.0, d12 - 1.0), this.a(this.d[i1 + 1], d7 - 1.0, 0.0, d12 - 1.0));
               double d16 = this.a(d14, d2, d4);
               par1ArrayOfDouble[k2++] += d16 * d5;
            }
         }
      } else {
         int j = 0;
         double d = 1.0 / par17;
         int j1 = -1;
         boolean flag4 = false;
         boolean flag5 = false;
         boolean flag6 = false;
         boolean flag7 = false;
         boolean flag8 = false;
         boolean flag9 = false;
         double d6 = 0.0;
         double d8 = 0.0;
         double d9 = 0.0;
         double d11 = 0.0;

         for (int j4 = 0; j4 < par8; j4++) {
            double d13 = par2 + j4 * par11 + this.a;
            long l4 = (long)d13;
            if (d13 < l4) {
               l4--;
            }

            int j5 = (int)(l4 & 255L);
            d13 -= l4;
            double d15 = d13 * d13 * d13 * (d13 * (d13 * 6.0 - 15.0) + 10.0);

            for (int k5 = 0; k5 < par10; k5++) {
               double d17 = par6 + k5 * par15 + this.c;
               long l5 = (long)d17;
               if (d17 < l5) {
                  l5--;
               }

               int i6 = (int)(l5 & 255L);
               d17 -= l5;
               double d18 = d17 * d17 * d17 * (d17 * (d17 * 6.0 - 15.0) + 10.0);

               for (int j6 = 0; j6 < par9; j6++) {
                  double d19 = par4 + j6 * par13 + this.b;
                  long k6 = (long)d19;
                  if (d19 < k6) {
                     k6--;
                  }

                  int l6 = (int)(k6 & 255L);
                  d19 -= k6;
                  double d20 = d19 * d19 * d19 * (d19 * (d19 * 6.0 - 15.0) + 10.0);
                  if (j6 == 0 || l6 != j1) {
                     j1 = l6;
                     int k1 = this.d[j5] + l6;
                     int l1 = this.d[k1] + i6;
                     int i2 = this.d[k1 + 1] + i6;
                     int j2 = this.d[j5 + 1] + l6;
                     int l2 = this.d[j2] + i6;
                     int i3 = this.d[j2 + 1] + i6;
                     d6 = this.a(d15, this.a(this.d[l1], d13, d19, d17), this.a(this.d[l2], d13 - 1.0, d19, d17));
                     d8 = this.a(d15, this.a(this.d[i2], d13, d19 - 1.0, d17), this.a(this.d[i3], d13 - 1.0, d19 - 1.0, d17));
                     d9 = this.a(d15, this.a(this.d[l1 + 1], d13, d19, d17 - 1.0), this.a(this.d[l2 + 1], d13 - 1.0, d19, d17 - 1.0));
                     d11 = this.a(d15, this.a(this.d[i2 + 1], d13, d19 - 1.0, d17 - 1.0), this.a(this.d[i3 + 1], d13 - 1.0, d19 - 1.0, d17 - 1.0));
                  }

                  double d21 = this.a(d20, d6, d8);
                  double d22 = this.a(d20, d9, d11);
                  double d23 = this.a(d18, d21, d22);
                  par1ArrayOfDouble[j++] += d23 * d;
               }
            }
         }
      }
   }
}
