import java.util.Random;

public class MapGenCavesHell extends MapGenBase {
   protected void generateLargeCaveNode(long par1, long par2, byte[] par3ArrayOfByte, double par4, double par6, double par8) {
      this.generateCaveNode(par1, par2, par3ArrayOfByte, par4, par6, par8, 1.0F + this.c.nextFloat() * 6.0F, 0.0F, 0.0F, -1, -1, 0.5);
   }

   protected void generateCaveNode(
      long par1,
      long par2,
      byte[] par3ArrayOfByte,
      double par4,
      double par6,
      double par8,
      float par10,
      float par11,
      float par12,
      int par13,
      int par14,
      double par15
   ) {
      double d = par1 * 16L + 8L;
      double d1 = par2 * 16L + 8L;
      float f = 0.0F;
      float f1 = 0.0F;
      Random random = new Random(this.c.nextLong());
      if (par14 <= 0) {
         int i = this.b * 16 - 16;
         par14 = i - random.nextInt(i / 4);
      }

      boolean flag = false;
      if (par13 == -1) {
         par13 = par14 / 2;
         flag = true;
      }

      int j = random.nextInt(par14 / 2) + par14 / 4;
      boolean flag1 = random.nextInt(6) == 0;

      while (par13 < par14) {
         double d2 = 1.5 + MathHelper.a(par13 * (float) Math.PI / par14) * par10 * 1.0F;
         double d3 = d2 * par15;
         float f2 = MathHelper.b(par12);
         float f3 = MathHelper.a(par12);
         par4 += MathHelper.b(par11) * f2;
         par6 += f3;
         par8 += MathHelper.a(par11) * f2;
         if (flag1) {
            par12 *= 0.92F;
         } else {
            par12 *= 0.7F;
         }

         par12 += f1 * 0.1F;
         par11 += f * 0.1F;
         f1 *= 0.9F;
         f *= 0.75F;
         f1 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
         f += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0F;
         if (!flag && par13 == j && par10 > 1.0F) {
            this.generateCaveNode(
               par1, par2, par3ArrayOfByte, par4, par6, par8, random.nextFloat() * 0.5F + 0.5F, par11 - (float) (Math.PI / 2), par12 / 3.0F, par13, par14, 1.0
            );
            this.generateCaveNode(
               par1, par2, par3ArrayOfByte, par4, par6, par8, random.nextFloat() * 0.5F + 0.5F, par11 + (float) (Math.PI / 2), par12 / 3.0F, par13, par14, 1.0
            );
            return;
         }

         if (flag || random.nextInt(4) != 0) {
            double d4 = par4 - d;
            double d5 = par8 - d1;
            double d6 = par14 - par13;
            double d7 = par10 + 2.0F + 16.0F;
            if (d4 * d4 + d5 * d5 - d6 * d6 > d7 * d7) {
               return;
            }

            if (!(par4 < d - 16.0 - d2 * 2.0) && !(par8 < d1 - 16.0 - d2 * 2.0) && !(par4 > d + 16.0 + d2 * 2.0) && !(par8 > d1 + 16.0 + d2 * 2.0)) {
               d4 = (int)(MathHelper.d(par4 - d2) - par1 * 16L - 1L);
               int k = (int)(MathHelper.d(par4 + d2) - par1 * 16L + 1L);
               d5 = MathHelper.c(par6 - d3) - 1;
               int l = MathHelper.c(par6 + d3) + 1;
               d6 = (int)(MathHelper.d(par8 - d2) - par2 * 16L - 1L);
               int i1 = (int)(MathHelper.d(par8 + d2) - par2 * 16L + 1L);
               if (d4 < 0.0) {
                  d4 = 0.0;
               }

               if (k > 16) {
                  k = 16;
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

               if (i1 > 16) {
                  i1 = 16;
               }

               boolean flag2 = false;

               for (int j1 = (int)d4; !flag2 && j1 < k; j1++) {
                  for (int l1 = (int)d6; !flag2 && l1 < i1; l1++) {
                     for (int i2 = l + 1; !flag2 && i2 >= d5 - 1.0; i2--) {
                        int j2 = (j1 * 16 + l1) * 128 + i2;
                        if (i2 >= 0 && i2 < 128) {
                           if (par3ArrayOfByte[j2] == Block.C.bO || par3ArrayOfByte[j2] == Block.D.bO) {
                              flag2 = true;
                           }

                           if (i2 != d5 - 1.0 && j1 != d4 && j1 != k - 1 && l1 != d6 && l1 != i1 - 1) {
                              i2 = (int)d5;
                           }
                        }
                     }
                  }
               }

               if (!flag2) {
                  for (int k1 = (int)d4; k1 < k; k1++) {
                     double d8 = (k1 + par1 * 16L + 0.5 - par4) / d2;

                     for (int k2 = (int)d6; k2 < i1; k2++) {
                        double d9 = (k2 + par2 * 16L + 0.5 - par8) / d2;
                        int l2 = (k1 * 16 + k2) * 128 + l;

                        for (int i3 = l - 1; i3 >= d5; i3--) {
                           double d10 = (i3 + 0.5 - par6) / d3;
                           if (d10 > -0.7 && d8 * d8 + d10 * d10 + d9 * d9 < 1.0) {
                              byte byte0 = par3ArrayOfByte[l2];
                              if (byte0 == Block.ItemBucket.bO || byte0 == Block.v.bO || byte0 == Block.u.bO) {
                                 par3ArrayOfByte[l2] = 0;
                              }
                           }

                           l2--;
                        }
                     }
                  }

                  if (flag) {
                     break;
                  }
               }
            }
         }

         par13++;
      }
   }

   @Override
   protected void recursiveGenerate(World par1World, long par2, long par3, long par4, long par5, byte[] par6ArrayOfByte) {
      int i = this.c.nextInt(this.c.nextInt(this.c.nextInt(10) + 1) + 1);
      if (this.c.nextInt(5) != 0) {
         i = 0;
      }

      for (int j = 0; j < i; j++) {
         double d = par2 * 16L + this.c.nextInt(16);
         double d1 = this.c.nextInt(128);
         double d2 = par3 * 16L + this.c.nextInt(16);
         int k = 1;
         if (this.c.nextInt(4) == 0) {
            this.generateLargeCaveNode(par4, par5, par6ArrayOfByte, d, d1, d2);
            k += this.c.nextInt(4);
         }

         for (int l = 0; l < k; l++) {
            float f = this.c.nextFloat() * (float) Math.PI * 2.0F;
            float f1 = (this.c.nextFloat() - 0.5F) * 2.0F / 8.0F;
            float f2 = this.c.nextFloat() * 2.0F + this.c.nextFloat();
            this.generateCaveNode(par4, par5, par6ArrayOfByte, d, d1, d2, f2 * 2.0F, f, f1, 0, 0, 0.5);
         }
      }
   }
}
