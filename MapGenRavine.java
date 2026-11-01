import java.util.Random;

public class MapGenRavine extends MapGenBase {
   private float[] a = new float[1024];

   protected void generateRavine(
      long par1,
      long par3,
      long par4,
      byte[] par5ArrayOfByte,
      double par6,
      double par8,
      double par10,
      float par12,
      float par13,
      float par14,
      int par15,
      int par16,
      double par17
   ) {
      Random random = new Random(par1);
      double d = par3 * 16L + 8L;
      double d1 = par4 * 16L + 8L;
      float f = 0.0F;
      float f1 = 0.0F;
      if (par16 <= 0) {
         int i = this.b * 16 - 16;
         par16 = i - random.nextInt(i / 4);
      }

      boolean flag = false;
      if (par15 == -1) {
         par15 = par16 / 2;
         flag = true;
      }

      float f2 = 1.0F;

      for (int j = 0; j < 128; j++) {
         if (j == 0 || random.nextInt(3) == 0) {
            f2 = 1.0F + random.nextFloat() * random.nextFloat() * 1.0F;
         }

         this.a[j] = f2 * f2;
      }

      for (; par15 < par16; par15++) {
         double d2 = 1.5 + MathHelper.a(par15 * (float) Math.PI / par16) * par12 * 1.0F;
         double d3 = d2 * par17;
         d2 *= random.nextFloat() * 0.25 + 0.75;
         d3 *= random.nextFloat() * 0.25 + 0.75;
         float f3 = MathHelper.b(par14);
         float f4 = MathHelper.a(par14);
         par6 += MathHelper.b(par13) * f3;
         par8 += f4;
         par10 += MathHelper.a(par13) * f3;
         par14 *= 0.7F;
         par14 += f1 * 0.05F;
         par13 += f * 0.05F;
         f1 *= 0.8F;
         f *= 0.5F;
         f1 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
         f += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0F;
         if (flag || random.nextInt(4) != 0) {
            double d4 = par6 - d;
            double d5 = par10 - d1;
            double d6 = par16 - par15;
            double d7 = par12 + 2.0F + 16.0F;
            if (d4 * d4 + d5 * d5 - d6 * d6 > d7 * d7) {
               return;
            }

            if (!(par6 < d - 16.0 - d2 * 2.0) && !(par10 < d1 - 16.0 - d2 * 2.0) && !(par6 > d + 16.0 + d2 * 2.0) && !(par10 > d1 + 16.0 + d2 * 2.0)) {
               d4 = MathHelper.d(par6 - d2) - par3 * 16L - 1L;
               long k = MathHelper.d(par6 + d2) - par3 * 16L + 1L;
               d5 = MathHelper.c(par8 - d3) - 1;
               int l = MathHelper.c(par8 + d3) + 1;
               d6 = MathHelper.d(par10 - d2) - par4 * 16L - 1L;
               long i1 = MathHelper.d(par10 + d2) - par4 * 16L + 1L;
               if (d4 < 0.0) {
                  d4 = 0.0;
               }

               if (k > 16L) {
                  k = 16L;
               }

               if (d5 < 1.0) {
                  d5 = 1.0;
               }

               if (l > 120) {
                  l = 120;
               }

               if (d6 < 0.0) {
                  d6 = 0.0;
               }

               if (i1 > 16L) {
                  i1 = 16L;
               }

               boolean flag1 = false;

               for (int j1 = (int)d4; !flag1 && j1 < k; j1++) {
                  for (int l1 = (int)d6; !flag1 && l1 < i1; l1++) {
                     for (int i2 = l + 1; !flag1 && i2 >= d5 - 1.0; i2--) {
                        int j2 = (j1 * 16 + l1) * 128 + i2;
                        if (i2 >= 0 && i2 < 128) {
                           if (par5ArrayOfByte[j2] == Block.A.bO || par5ArrayOfByte[j2] == Block.B.bO) {
                              flag1 = true;
                           }

                           if (i2 != d5 - 1.0 && j1 != d4 && j1 != k - 1L && l1 != d6 && l1 != i1 - 1L) {
                              i2 = (int)d5;
                           }
                        }
                     }
                  }
               }

               if (!flag1) {
                  for (int k1 = (int)d4; k1 < k; k1++) {
                     double d8 = (k1 + par3 * 16L + 0.5 - par6) / d2;

                     for (int k2 = (int)d6; k2 < i1; k2++) {
                        double d9 = (k2 + par4 * 16L + 0.5 - par10) / d2;
                        int l2 = (k1 * 16 + k2) * 128 + l;
                        boolean flag2 = false;
                        if (!(d8 * d8 + d9 * d9 >= 1.0)) {
                           for (int i3 = l - 1; !(i3 < d5); i3--) {
                              double d10 = (i3 + 0.5 - par8) / d3;
                              if ((d8 * d8 + d9 * d9) * this.a[i3] + d10 * d10 / 6.0 < 1.0) {
                                 byte byte0 = par5ArrayOfByte[l2];
                                 if (byte0 == Block.u.bO) {
                                    flag2 = true;
                                 }

                                 if (byte0 == Block.t.bO || byte0 == Block.v.bO || byte0 == Block.u.bO) {
                                    if (i3 < 10) {
                                       par5ArrayOfByte[l2] = (byte)Block.C.bO;
                                    } else {
                                       par5ArrayOfByte[l2] = 0;
                                       if (flag2 && par5ArrayOfByte[l2 - 1] == Block.v.bO) {
                                          par5ArrayOfByte[l2 - 1] = this.d.getBiomeGenForCoords(k1 + par3 * 16L, k2 + par4 * 16L).A;
                                       }
                                    }
                                 }
                              }

                              l2--;
                           }
                        }
                     }
                  }

                  if (flag) {
                     break;
                  }
               }
            }
         }
      }
   }

   @Override
   protected void recursiveGenerate(World par1World, long par2, long par3, long par4, long par5, byte[] par6ArrayOfByte) {
      if (this.c.nextInt(50) == 0) {
         double d = par2 * 16L + this.c.nextInt(16);
         double d1 = this.c.nextInt(this.c.nextInt(40) + 8) + 20;
         double d2 = par3 * 16L + this.c.nextInt(16);
         int i = 1;

         for (int j = 0; j < i; j++) {
            float f = this.c.nextFloat() * (float) Math.PI * 2.0F;
            float f1 = (this.c.nextFloat() - 0.5F) * 2.0F / 8.0F;
            float f2 = (this.c.nextFloat() * 2.0F + this.c.nextFloat()) * 2.0F;
            this.generateRavine(this.c.nextLong(), par4, par5, par6ArrayOfByte, d, d1, d2, f2, f, f1, 0, 0, 3.0);
         }
      }
   }
}
