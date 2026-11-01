import java.util.Random;

public class Teleporter {
   private Random a = new Random();

   public void a(World par1World, Entity par2Entity) {
      if (par1World.t.g != 1) {
         if (!this.b(par1World, par2Entity)) {
            this.c(par1World, par2Entity);
            this.b(par1World, par2Entity);
         }
      } else {
         long i = MathHelper.d(par2Entity.o);
         int j = MathHelper.c(par2Entity.p) - 1;
         long k = MathHelper.d(par2Entity.q);
         int l = 1;
         int i1 = 0;

         for (int j1 = -2; j1 <= 2; j1++) {
            for (int k1 = -2; k1 <= 2; k1++) {
               for (int l1 = -1; l1 < 3; l1++) {
                  long i2 = i + k1 * l + j1 * i1;
                  int j2 = j + l1;
                  long k2 = k + k1 * i1 - j1 * l;
                  boolean flag = l1 < 0;
                  par1World.setBlockWithNotify(i2, j2, k2, flag ? Block.ap.bO : 0);
               }
            }
         }

         par2Entity.c(i, j, k, par2Entity.u, 0.0F);
         par2Entity.r = par2Entity.s = par2Entity.t = 0.0;
      }
   }

   public boolean b(World par1World, Entity par2Entity) {
      char c = 128;
      double d = -1.0;
      long i = 0L;
      int j = 0;
      long k = 0L;
      long l = MathHelper.d(par2Entity.o);
      long i1 = MathHelper.d(par2Entity.q);

      for (long j1 = l - c; j1 <= l + c; j1++) {
         double d1 = j1 + 0.5 - par2Entity.o;

         for (long j2 = i1 - c; j2 <= i1 + c; j2++) {
            double d3 = j2 + 0.5 - par2Entity.q;

            for (int k2 = 127; k2 >= 0; k2--) {
               if (par1World.getBlockId(j1, k2, j2) == Block.be.bO) {
                  while (par1World.getBlockId(j1, k2 - 1, j2) == Block.be.bO) {
                     k2--;
                  }

                  double d5 = k2 + 0.5 - par2Entity.p;
                  double d7 = d1 * d1 + d5 * d5 + d3 * d3;
                  if (d < 0.0 || d7 < d) {
                     d = d7;
                     i = j1;
                     j = k2;
                     k = j2;
                  }
               }
            }
         }
      }

      if (d >= 0.0) {
         long k1 = i;
         int l1 = j;
         long i2 = k;
         double d2 = k1 + 0.5;
         double d4 = l1 + 0.5;
         double d6 = i2 + 0.5;
         if (par1World.getBlockId(k1 - 1L, l1, i2) == Block.be.bO) {
            d2 -= 0.5;
         }

         if (par1World.getBlockId(k1 + 1L, l1, i2) == Block.be.bO) {
            d2 += 0.5;
         }

         if (par1World.getBlockId(k1, l1, i2 - 1L) == Block.be.bO) {
            d6 -= 0.5;
         }

         if (par1World.getBlockId(k1, l1, i2 + 1L) == Block.be.bO) {
            d6 += 0.5;
         }

         par2Entity.c(d2, d4, d6, par2Entity.u, 0.0F);
         par2Entity.r = par2Entity.s = par2Entity.t = 0.0;
         return true;
      } else {
         return false;
      }
   }

   public boolean c(World par1World, Entity par2Entity) {
      byte byte0 = 16;
      double d = -1.0;
      long i = MathHelper.d(par2Entity.o);
      int j = MathHelper.c(par2Entity.p);
      long k = MathHelper.d(par2Entity.q);
      long l = i;
      int i1 = j;
      long j1 = k;
      int k1 = 0;
      int l1 = this.a.nextInt(4);

      for (long i2 = i - byte0; i2 <= i + byte0; i2++) {
         double d1 = i2 + 0.5 - par2Entity.o;

         for (long j3 = k - byte0; j3 <= k + byte0; j3++) {
            double d3 = j3 + 0.5 - par2Entity.q;

            label299:
            for (int k4 = 127; k4 >= 0; k4--) {
               if (par1World.isAirBlock(i2, k4, j3)) {
                  while (k4 > 0 && par1World.isAirBlock(i2, k4 - 1, j3)) {
                     k4--;
                  }

                  for (int k5 = l1; k5 < l1 + 4; k5++) {
                     int l6 = k5 % 2;
                     int i8 = 1 - l6;
                     if (k5 % 4 >= 2) {
                        l6 = -l6;
                        i8 = -i8;
                     }

                     for (int j9 = 0; j9 < 3; j9++) {
                        for (int k10 = 0; k10 < 4; k10++) {
                           for (int l11 = -1; l11 < 4; l11++) {
                              long j12 = i2 + (k10 - 1) * l6 + j9 * i8;
                              int l12 = k4 + l11;
                              long j13 = j3 + (k10 - 1) * i8 - j9 * l6;
                              if (l11 < 0 && !par1World.getBlockMaterial(j12, l12, j13).a() || l11 >= 0 && !par1World.isAirBlock(j12, l12, j13)) {
                                 continue label299;
                              }
                           }
                        }
                     }

                     double d5 = k4 + 0.5 - par2Entity.p;
                     double d7 = d1 * d1 + d5 * d5 + d3 * d3;
                     if (d < 0.0 || d7 < d) {
                        d = d7;
                        l = i2;
                        i1 = k4;
                        j1 = j3;
                        k1 = k5 % 4;
                     }
                  }
               }
            }
         }
      }

      if (d < 0.0) {
         for (long j2 = i - byte0; j2 <= i + byte0; j2++) {
            double d2 = j2 + 0.5 - par2Entity.o;

            for (long k3 = k - byte0; k3 <= k + byte0; k3++) {
               double d4 = k3 + 0.5 - par2Entity.q;

               label236:
               for (int l4 = 127; l4 >= 0; l4--) {
                  if (par1World.isAirBlock(j2, l4, k3)) {
                     while (l4 > 0 && par1World.isAirBlock(j2, l4 - 1, k3)) {
                        l4--;
                     }

                     for (int l5 = l1; l5 < l1 + 2; l5++) {
                        int i7 = l5 % 2;
                        int j8 = 1 - i7;

                        for (int k9 = 0; k9 < 4; k9++) {
                           for (int l10 = -1; l10 < 4; l10++) {
                              long i12 = j2 + (k9 - 1) * i7;
                              int k12 = l4 + l10;
                              long i13 = k3 + (k9 - 1) * j8;
                              if (l10 < 0 && !par1World.getBlockMaterial(i12, k12, i13).a() || l10 >= 0 && !par1World.isAirBlock(i12, k12, i13)) {
                                 continue label236;
                              }
                           }
                        }

                        double d6 = l4 + 0.5 - par2Entity.p;
                        double d8 = d2 * d2 + d6 * d6 + d4 * d4;
                        if (d < 0.0 || d8 < d) {
                           d = d8;
                           l = j2;
                           i1 = l4;
                           j1 = k3;
                           k1 = l5 % 2;
                        }
                     }
                  }
               }
            }
         }
      }

      int k2 = k1;
      long l2 = l;
      int i3 = i1;
      long l3 = j1;
      int i4 = k2 % 2;
      int j4 = 1 - i4;
      if (k2 % 4 >= 2) {
         i4 = -i4;
         j4 = -j4;
      }

      if (d < 0.0) {
         if (i1 < 70) {
            i1 = 70;
         }

         if (i1 > 118) {
            i1 = 118;
         }

         i3 = i1;

         for (int i5 = -1; i5 <= 1; i5++) {
            for (int i6 = 1; i6 < 3; i6++) {
               for (int j7 = -1; j7 < 3; j7++) {
                  long k8 = l2 + (i6 - 1) * i4 + i5 * j4;
                  int l9 = i3 + j7;
                  long i11 = l3 + (i6 - 1) * j4 - i5 * i4;
                  boolean flag = j7 < 0;
                  par1World.setBlockWithNotify(k8, l9, i11, flag ? Block.ap.bO : 0);
               }
            }
         }
      }

      for (int j5 = 0; j5 < 4; j5++) {
         par1World.o = true;

         for (int j6 = 0; j6 < 4; j6++) {
            for (int k7 = -1; k7 < 4; k7++) {
               long l8 = l2 + (j6 - 1) * i4;
               int i10 = i3 + k7;
               long j11 = l3 + (j6 - 1) * j4;
               boolean flag1 = j6 == 0 || j6 == 3 || k7 == -1 || k7 == 3;
               par1World.setBlockWithNotify(l8, i10, j11, flag1 ? Block.ap.bO : Block.be.bO);
            }
         }

         par1World.o = false;

         for (int k6 = 0; k6 < 4; k6++) {
            for (int l7 = -1; l7 < 4; l7++) {
               long i9 = l2 + (k6 - 1) * i4;
               int j10 = i3 + l7;
               long k11 = l3 + (k6 - 1) * j4;
               par1World.notifyBlocksOfNeighborChange(i9, j10, k11, par1World.getBlockId(i9, j10, k11));
            }
         }
      }

      return true;
   }
}
