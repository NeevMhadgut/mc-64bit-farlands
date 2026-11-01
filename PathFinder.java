public class PathFinder {
   private IBlockAccess a;
   private acc b = new acc();
   private abh c = new abh();
   private e[] d = new e[32];
   private boolean e;
   private boolean f;
   private boolean g;
   private boolean h;

   public PathFinder(IBlockAccess par1IBlockAccess, boolean par2, boolean par3, boolean par4, boolean par5) {
      this.a = par1IBlockAccess;
      this.e = par2;
      this.f = par3;
      this.g = par4;
      this.h = par5;
   }

   public PathEntity a(Entity par1Entity, Entity par2Entity, float par3) {
      return this.a(par1Entity, par2Entity.o, par2Entity.y.b, par2Entity.q, par3);
   }

   public PathEntity createEntityPathTo(Entity par1Entity, long par2, int par3, long par4, float par5) {
      return this.a(par1Entity, par2 + 0.5, par3 + 0.5F, par4 + 0.5, par5);
   }

   private PathEntity a(Entity par1Entity, double par2, double par4, double par6, float par8) {
      this.b.a();
      this.c.a();
      boolean flag = this.g;
      int i = MathHelper.c(par1Entity.y.b + 0.5);
      if (this.h && par1Entity.H()) {
         i = (int)par1Entity.y.b;
         int j = this.a.getBlockId(MathHelper.d(par1Entity.o), i, MathHelper.d(par1Entity.q));

         while (j == Block.A.bO || j == Block.B.bO) {
            j = this.a.getBlockId(MathHelper.d(par1Entity.o), ++i, MathHelper.d(par1Entity.q));
         }

         flag = this.g;
         this.g = false;
      } else {
         i = MathHelper.c(par1Entity.y.b + 0.5);
      }

      e pathpoint = this.openPoint(MathHelper.d(par1Entity.y.a), i, MathHelper.d(par1Entity.y.c));
      e pathpoint1 = this.openPoint(MathHelper.d(par2 - par1Entity.I / 2.0F), MathHelper.c(par4), MathHelper.d(par6 - par1Entity.I / 2.0F));
      e pathpoint2 = new e(MathHelper.d(par1Entity.I + 1.0), MathHelper.d(par1Entity.J + 1.0F), MathHelper.d(par1Entity.I + 1.0));
      PathEntity pathentity = this.a(par1Entity, pathpoint, pathpoint1, pathpoint2, par8);
      this.g = flag;
      return pathentity;
   }

   private PathEntity a(Entity par1Entity, e par2PathPoint, e par3PathPoint, e par4PathPoint, float par5) {
      par2PathPoint.e = 0.0F;
      par2PathPoint.f = par2PathPoint.a(par3PathPoint);
      par2PathPoint.g = par2PathPoint.f;
      this.b.a();
      this.b.a(par2PathPoint);
      e pathpoint = par2PathPoint;

      while (!this.b.c()) {
         e pathpoint1 = this.b.b();
         if (pathpoint1.equals(par3PathPoint)) {
            return this.a(par2PathPoint, par3PathPoint);
         }

         if (pathpoint1.a(par3PathPoint) < pathpoint.a(par3PathPoint)) {
            pathpoint = pathpoint1;
         }

         pathpoint1.i = true;
         int i = this.b(par1Entity, pathpoint1, par4PathPoint, par3PathPoint, par5);

         for (int j = 0; j < i; j++) {
            e pathpoint2 = this.d[j];
            float f = pathpoint1.e + pathpoint1.a(pathpoint2);
            if (!pathpoint2.a() || f < pathpoint2.e) {
               pathpoint2.h = pathpoint1;
               pathpoint2.e = f;
               pathpoint2.f = pathpoint2.a(par3PathPoint);
               if (pathpoint2.a()) {
                  this.b.a(pathpoint2, pathpoint2.e + pathpoint2.f);
               } else {
                  pathpoint2.g = pathpoint2.e + pathpoint2.f;
                  this.b.a(pathpoint2);
               }
            }
         }
      }

      return pathpoint == par2PathPoint ? null : this.a(par2PathPoint, pathpoint);
   }

   private int b(Entity par1Entity, e par2PathPoint, e par3PathPoint, e par4PathPoint, float par5) {
      int i = 0;
      int j = 0;
      if (this.getVerticalOffset(par1Entity, par2PathPoint.a, par2PathPoint.b + 1, par2PathPoint.c, par3PathPoint) == 1) {
         j = 1;
      }

      e pathpoint = this.getSafePoint(par1Entity, par2PathPoint.a, par2PathPoint.b, par2PathPoint.c + 1L, par3PathPoint, j);
      e pathpoint1 = this.getSafePoint(par1Entity, par2PathPoint.a - 1L, par2PathPoint.b, par2PathPoint.c, par3PathPoint, j);
      e pathpoint2 = this.getSafePoint(par1Entity, par2PathPoint.a + 1L, par2PathPoint.b, par2PathPoint.c, par3PathPoint, j);
      e pathpoint3 = this.getSafePoint(par1Entity, par2PathPoint.a, par2PathPoint.b, par2PathPoint.c - 1L, par3PathPoint, j);
      if (pathpoint != null && !pathpoint.i && pathpoint.a(par4PathPoint) < par5) {
         this.d[i++] = pathpoint;
      }

      if (pathpoint1 != null && !pathpoint1.i && pathpoint1.a(par4PathPoint) < par5) {
         this.d[i++] = pathpoint1;
      }

      if (pathpoint2 != null && !pathpoint2.i && pathpoint2.a(par4PathPoint) < par5) {
         this.d[i++] = pathpoint2;
      }

      if (pathpoint3 != null && !pathpoint3.i && pathpoint3.a(par4PathPoint) < par5) {
         this.d[i++] = pathpoint3;
      }

      return i;
   }

   private e getSafePoint(Entity par1Entity, long par2, int par3, long par4, e par5PathPoint, int par6) {
      e pathpoint = null;
      int i = this.getVerticalOffset(par1Entity, par2, par3, par4, par5PathPoint);
      if (i == 2) {
         return this.openPoint(par2, par3, par4);
      }

      if (i == 1) {
         pathpoint = this.openPoint(par2, par3, par4);
      }

      if (pathpoint == null && par6 > 0 && i != -3 && i != -4 && this.getVerticalOffset(par1Entity, par2, par3 + par6, par4, par5PathPoint) == 1) {
         pathpoint = this.openPoint(par2, par3 + par6, par4);
         par3 += par6;
      }

      if (pathpoint != null) {
         int j = 0;
         int k = 0;

         while (par3 > 0) {
            k = this.getVerticalOffset(par1Entity, par2, par3 - 1, par4, par5PathPoint);
            if (this.g && k == -1) {
               return null;
            }

            if (k != 1) {
               break;
            }

            if (++j >= 4) {
               return null;
            }

            if (--par3 > 0) {
               pathpoint = this.openPoint(par2, par3, par4);
            }
         }

         if (k == -2) {
            return null;
         }
      }

      return pathpoint;
   }

   private final e openPoint(long par1, int par2, long par3) {
      int i = e.makeHash(par1, par2, par3);
      e pathpoint = (e)this.c.a(i);
      if (pathpoint == null) {
         pathpoint = new e(par1, par2, par3);
         this.c.a(i, pathpoint);
      }

      return pathpoint;
   }

   private int getVerticalOffset(Entity par1Entity, long par2, int par3, long par4, e par5PathPoint) {
      boolean flag = false;

      for (long i = par2; i < par2 + par5PathPoint.a; i++) {
         for (int j = par3; j < par3 + par5PathPoint.b; j++) {
            for (long k = par4; k < par4 + par5PathPoint.c; k++) {
               int l = this.a.getBlockId(i, j, k);
               if (l > 0) {
                  if (l == Block.bk.bO) {
                     flag = true;
                  } else if (l != Block.A.bO && l != Block.B.bO) {
                     if (!this.e && l == Block.aE.bO) {
                        return 0;
                     }
                  } else {
                     if (this.g) {
                        return -1;
                     }

                     flag = true;
                  }

                  Block block = Block.m[l];
                  if (!block.getBlocksMovement(this.a, i, j, k) && (!this.f || l != Block.aE.bO)) {
                     if (l == Block.aZ.bO || l == Block.bv.bO) {
                        return -3;
                     }

                     if (l == Block.bk.bO) {
                        return -4;
                     }

                     acn material = block.cd;
                     if (material != acn.h) {
                        return 0;
                     }

                     if (!par1Entity.J()) {
                        return -2;
                     }
                  }
               }
            }
         }
      }

      return flag ? 2 : 1;
   }

   private PathEntity a(e par1PathPoint, e par2PathPoint) {
      int i = 1;

      for (e pathpoint = par2PathPoint; pathpoint.h != null; pathpoint = pathpoint.h) {
         i++;
      }

      e[] apathpoint = new e[i];
      e pathpoint1 = par2PathPoint;

      for (apathpoint[--i] = pathpoint1; pathpoint1.h != null; apathpoint[--i] = pathpoint1) {
         pathpoint1 = pathpoint1.h;
      }

      return new PathEntity(apathpoint);
   }
}
