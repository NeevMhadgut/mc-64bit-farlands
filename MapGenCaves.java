import java.util.Random;

public class MapGenCaves extends MapGenBase {
   protected void generateLargeCaveNode(long par1, long par3, long par4, byte[] par5ArrayOfByte, double par6, double par8, double par10) {
      this.generateCaveNode(par1, par3, par4, par5ArrayOfByte, par6, par8, par10, 1.0F + this.c.nextFloat() * 6.0F, 0.0F, 0.0F, -1, -1, 0.5);
   }

   protected void generateCaveNode(
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
      double d = par3 * 16L + 8L;
      double d1 = par4 * 16L + 8L;
      float f = 0.0F;
      float f1 = 0.0F;
      Random random = new Random(par1);
      if (par16 <= 0) {
         int i = this.b * 16 - 16;
         par16 = i - random.nextInt(i / 4);
      }

      boolean flag = false;
      if (par15 == -1) {
         par15 = par16 / 2;
         flag = true;
      }

      int j = random.nextInt(par16 / 2) + par16 / 4;
      boolean flag1 = random.nextInt(6) == 0;

      while (par15 < par16) {
         double d2 = 1.5 + MathHelper.a(par15 * (float) Math.PI / par16) * par12 * 1.0F;
         double d3 = d2 * par17;
         float f2 = MathHelper.b(par14);
         float f3 = MathHelper.a(par14);
         par6 += MathHelper.b(par13) * f2;
         par8 += f3;
         par10 += MathHelper.a(par13) * f2;
         if (flag1) {
            par14 *= 0.92F;
         } else {
            par14 *= 0.7F;
         }

         par14 += f1 * 0.1F;
         par13 += f * 0.1F;
         f1 *= 0.9F;
         f *= 0.75F;
         f1 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
         f += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0F;
         if (!flag && par15 == j && par12 > 1.0F && par16 > 0) {
            this.generateCaveNode(
               random.nextLong(),
               par3,
               par4,
               par5ArrayOfByte,
               par6,
               par8,
               par10,
               random.nextFloat() * 0.5F + 0.5F,
               par13 - (float) (Math.PI / 2),
               par14 / 3.0F,
               par15,
               par16,
               1.0
            );
            this.generateCaveNode(
               random.nextLong(),
               par3,
               par4,
               par5ArrayOfByte,
               par6,
               par8,
               par10,
               random.nextFloat() * 0.5F + 0.5F,
               par13 + (float) (Math.PI / 2),
               par14 / 3.0F,
               par15,
               par16,
               1.0
            );
            return;
         }

         if (flag || random.nextInt(4) != 0) {
            double d4D = par6 - d;
            double d5D = par10 - d1;
            double d6D = par16 - par15;
            double d7 = par12 + 2.0F + 16.0F;
            if (d4D * d4D + d5D * d5D - d6D * d6D > d7 * d7) {
               return;
            }

            if (!(par6 < d - 16.0 - d2 * 2.0) && !(par10 < d1 - 16.0 - d2 * 2.0) && !(par6 > d + 16.0 + d2 * 2.0) && !(par10 > d1 + 16.0 + d2 * 2.0)) {
               int d4 = (int)(MathHelper.d(par6 - d2) - par3 * 16L - 1L);
               int k = (int)(MathHelper.d(par6 + d2) - par3 * 16L + 1L);
               int d5 = MathHelper.c(par8 - d3) - 1;
               int l = MathHelper.c(par8 + d3) + 1;
               int d6 = (int)(MathHelper.d(par10 - d2) - par4 * 16L - 1L);
               int i1 = (int)(MathHelper.d(par10 + d2) - par4 * 16L + 1L);
               if (d4 < 0) {
                  d4 = 0;
               }

               if (k > 16) {
                  k = 16;
               }

               if (d5 < 1) {
                  d5 = 1;
               }

               if (l > 120) {
                  l = 120;
               }

               if (d6 < 0) {
                  d6 = 0;
               }

               if (i1 > 16) {
                  i1 = 16;
               }

               boolean flag2 = false;

               for (int j1 = d4; !flag2 && j1 < k; j1++) {
                  for (int l1 = d6; !flag2 && l1 < i1; l1++) {
                     for (int i2 = l + 1; !flag2 && i2 >= d5 - 1; i2--) {
                        int j2 = (j1 * 16 + l1) * 128 + i2;
                        if (i2 >= 0 && i2 < 128) {
                           if (par5ArrayOfByte[j2] == Block.A.bO || par5ArrayOfByte[j2] == Block.B.bO) {
                              flag2 = true;
                           }

                           if (i2 != d5 - 1 && j1 != d4 && j1 != k - 1 && l1 != d6 && l1 != i1 - 1) {
                              i2 = d5;
                           }
                        }
                     }
                  }
               }

               if (!flag2) {
                  for (int k1 = d4; k1 < k; k1++) {
                     double d8 = (k1 + par3 * 16L + 0.5 - par6) / d2;

                     for (int k2 = d6; k2 < i1; k2++) {
                        double d9 = (k2 + par4 * 16L + 0.5 - par10) / d2;
                        int l2 = (k1 * 16 + k2) * 128 + l;
                        boolean flag3 = false;
                        if (!(d8 * d8 + d9 * d9 >= 1.0)) {
                           for (int i3 = l - 1; i3 >= d5; i3--) {
                              double d10 = (i3 + 0.5 - par8) / d3;
                              if (d10 > -0.7 && d8 * d8 + d10 * d10 + d9 * d9 < 1.0) {
                                 byte byte0 = par5ArrayOfByte[l2];
                                 if (byte0 == Block.u.bO) {
                                    flag3 = true;
                                 }

                                 if (byte0 == Block.t.bO || byte0 == Block.v.bO || byte0 == Block.u.bO) {
                                    if (i3 < 10) {
                                       par5ArrayOfByte[l2] = (byte)Block.C.bO;
                                    } else {
                                       par5ArrayOfByte[l2] = 0;
                                       if (flag3 && par5ArrayOfByte[l2 - 1] == Block.v.bO) {
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

         par15++;
      }
   }

   @Override
   protected void recursiveGenerate(World par1World, long par2, long par3, long par4, long par5, byte[] par6ArrayOfByte) {
      int i = this.c.nextInt(this.c.nextInt(this.c.nextInt(40) + 1) + 1);
      if (this.c.nextInt(15) != 0) {
         i = 0;
      }

      for (int j = 0; j < i; j++) {
         double d = par2 * 16L + this.c.nextInt(16);
         double d1 = this.c.nextInt(this.c.nextInt(120) + 8);
         double d2 = par3 * 16L + this.c.nextInt(16);
         int k = 1;
         if (this.c.nextInt(4) == 0) {
            this.generateLargeCaveNode(this.c.nextLong(), par4, par5, par6ArrayOfByte, d, d1, d2);
            k += this.c.nextInt(4);
         }

         for (int l = 0; l < k; l++) {
            float f = this.c.nextFloat() * (float) Math.PI * 2.0F;
            float f1 = (this.c.nextFloat() - 0.5F) * 2.0F / 8.0F;
            float f2 = this.c.nextFloat() * 2.0F + this.c.nextFloat();
            if (this.c.nextInt(10) == 0) {
               f2 *= this.c.nextFloat() * this.c.nextFloat() * 3.0F + 1.0F;
            }

            this.generateCaveNode(this.c.nextLong(), par4, par5, par6ArrayOfByte, d, d1, d2, f2, f, f1, 0, 0, 1.0);
         }
      }
   }
}
