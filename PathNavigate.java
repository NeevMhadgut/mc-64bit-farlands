public class PathNavigate {
   private EntityLiving a;
   private World b;
   private PathEntity c;
   private float d;
   private float e;
   private boolean f = false;
   private int g;
   private int h;
   private bo i = bo.a(0.0, 0.0, 0.0);
   private boolean j = true;
   private boolean k = false;
   private boolean l = false;
   private boolean m = false;

   public PathNavigate(EntityLiving par1EntityLiving, World par2World, float par3) {
      this.a = par1EntityLiving;
      this.b = par2World;
      this.e = par3;
   }

   public void a(boolean par1) {
      this.l = par1;
   }

   public boolean a() {
      return this.l;
   }

   public void b(boolean par1) {
      this.k = par1;
   }

   public void c(boolean par1) {
      this.j = par1;
   }

   public boolean b() {
      return this.k;
   }

   public void d(boolean par1) {
      this.f = par1;
   }

   public void a(float par1) {
      this.d = par1;
   }

   public void e(boolean par1) {
      this.m = par1;
   }

   public PathEntity a(double par1, double par3, double par5) {
      return !this.j() ? null : this.b.getEntityPathToXYZ(this.a, MathHelper.d(par1), (int)par3, MathHelper.d(par5), this.e, this.j, this.k, this.l, this.m);
   }

   public boolean a(double par1, double par3, double par5, float par7) {
      PathEntity pathentity = this.a(MathHelper.d(par1), (int)par3, MathHelper.d(par5));
      return this.a(pathentity, par7);
   }

   public PathEntity a(EntityLiving par1EntityLiving) {
      return !this.j() ? null : this.b.a(this.a, par1EntityLiving, this.e, this.j, this.k, this.l, this.m);
   }

   public boolean a(EntityLiving par1EntityLiving, float par2) {
      PathEntity pathentity = this.a(par1EntityLiving);
      return pathentity != null ? this.a(pathentity, par2) : false;
   }

   public boolean a(PathEntity par1PathEntity, float par2) {
      if (par1PathEntity == null) {
         this.c = null;
         return false;
      }

      if (!par1PathEntity.a(this.c)) {
         this.c = par1PathEntity;
      }

      if (this.f) {
         this.l();
      }

      if (this.c.d() == 0) {
         return false;
      }

      this.d = par2;
      bo vec3d = this.h();
      this.h = this.g;
      this.i.a = vec3d.a;
      this.i.b = vec3d.b;
      this.i.c = vec3d.c;
      return true;
   }

   public PathEntity c() {
      return this.c;
   }

   public void d() {
      this.g++;
      if (!this.e()) {
         if (this.j()) {
            this.g();
         }

         if (!this.e()) {
            bo vec3d = this.c.a(this.a);
            if (vec3d != null) {
               this.a.aK().a(vec3d.a, vec3d.b, vec3d.c, this.d);
            }
         }
      }
   }

   private void g() {
      bo vec3d = this.h();
      int i = this.c.d();

      for (int i2 = this.c.e(); i2 < this.c.d(); i2++) {
         if (this.c.a(i2).b != (int)vec3d.b) {
            i = i2;
            break;
         }
      }

      float f = this.a.I * this.a.I;

      for (int j = this.c.e(); j < i; j++) {
         if (vec3d.e(this.c.a(this.a, j)) < f) {
            this.c.c(j + 1);
         }
      }

      int k = (int)Math.ceil(this.a.I);
      int l = (int)this.a.J + 1;
      int i1 = k;

      for (int j1 = i - 1; j1 >= this.c.e(); j1--) {
         if (this.a(vec3d, this.c.a(this.a, j1), k, l, i1)) {
            this.c.c(j1);
            break;
         }
      }

      if (this.g - this.h > 100) {
         if (vec3d.e(this.i) < 2.25) {
            this.f();
         }

         this.h = this.g;
         this.i.a = vec3d.a;
         this.i.b = vec3d.b;
         this.i.c = vec3d.c;
      }
   }

   public boolean e() {
      return this.c == null || this.c.b();
   }

   public void f() {
      this.c = null;
   }

   private bo h() {
      return bo.b(this.a.o, this.i(), this.a.q);
   }

   private int i() {
      if (this.a.H() && this.m) {
         int i = (int)this.a.y.b;
         int j = this.b.getBlockId(MathHelper.d(this.a.o), i, MathHelper.d(this.a.q));
         int k = 0;

         while (j == Block.A.bO || j == Block.B.bO) {
            j = this.b.getBlockId(MathHelper.d(this.a.o), ++i, MathHelper.d(this.a.q));
            if (++k > 16) {
               return (int)this.a.y.b;
            }
         }

         return i;
      } else {
         return (int)(this.a.y.b + 0.5);
      }
   }

   private boolean j() {
      return this.a.z || this.m && this.k();
   }

   private boolean k() {
      return this.a.H() || this.a.J();
   }

   private void l() {
      if (!this.b.canBlockSeeTheSky(MathHelper.d(this.a.o), (int)(this.a.y.b + 0.5), MathHelper.d(this.a.q))) {
         for (int i = 0; i < this.c.d(); i++) {
            e pathpoint = this.c.a(i);
            if (this.b.canBlockSeeTheSky(pathpoint.a, pathpoint.b, pathpoint.c)) {
               this.c.b(i - 1);
               return;
            }
         }
      }
   }

   private boolean a(bo par1Vec3D, bo par2Vec3D, int par3, int par4, int par5) {
      long i = MathHelper.d(par1Vec3D.a);
      long j = MathHelper.d(par1Vec3D.c);
      double d = par2Vec3D.a - par1Vec3D.a;
      double d1 = par2Vec3D.c - par1Vec3D.c;
      double d2 = d * d + d1 * d1;
      if (d2 < 1.0E-8) {
         return false;
      }

      double d3 = 1.0 / Math.sqrt(d2);
      d *= d3;
      d1 *= d3;
      par3 += 2;
      par5 += 2;
      if (!this.isSafeToStandAt(i, (int)par1Vec3D.b, j, par3, par4, par5, par1Vec3D, d, d1)) {
         return false;
      }

      par3 -= 2;
      par5 -= 2;
      double d4 = 1.0 / Math.abs(d);
      double d5 = 1.0 / Math.abs(d1);
      double d6 = i * 1L - par1Vec3D.a;
      double d7 = j * 1L - par1Vec3D.c;
      if (d >= 0.0) {
         d6++;
      }

      if (d1 >= 0.0) {
         d7++;
      }

      d6 /= d;
      d7 /= d1;
      byte byte0 = (byte)(d >= 0.0 ? 1 : -1);
      byte byte1 = (byte)(d1 >= 0.0 ? 1 : -1);
      long k = MathHelper.d(par2Vec3D.a);
      long l = MathHelper.d(par2Vec3D.c);
      int i1 = (int)(k - i);
      int j1 = (int)(l - j);

      while (i1 * byte0 > 0 || j1 * byte1 > 0) {
         if (d6 < d7) {
            d6 += d4;
            i += byte0;
            i1 = (int)(k - i);
         } else {
            d7 += d5;
            j += byte1;
            j1 = (int)(l - j);
         }

         if (!this.isSafeToStandAt(i, (int)par1Vec3D.b, j, par3, par4, par5, par1Vec3D, d, d1)) {
            return false;
         }
      }

      return true;
   }

   private boolean isSafeToStandAt(long par1, int par2, long par3, int par4, int par5, int par6, bo par7Vec3D, double par8, double par10) {
      long i = par1 - par4 / 2;
      long j = par3 - par6 / 2;
      if (!this.isPositionClear(i, par2, j, par4, par5, par6, par7Vec3D, par8, par10)) {
         return false;
      }

      for (long k = i; k < i + par4; k++) {
         for (long l = j; l < j + par6; l++) {
            double d = k + 0.5 - par7Vec3D.a;
            double d1 = l + 0.5 - par7Vec3D.c;
            if (!(d * par8 + d1 * par10 < 0.0)) {
               int i1 = this.b.getBlockId(k, par2 - 1, l);
               if (i1 <= 0) {
                  return false;
               }

               acn material = Block.m[i1].cd;
               if (material == acn.g && !this.a.H()) {
                  return false;
               }

               if (material == acn.h) {
                  return false;
               }
            }
         }
      }

      return true;
   }

   private boolean isPositionClear(long par1, int par2, long par3, int par4, int par5, int par6, bo par7Vec3D, double par8, double par10) {
      for (long i = par1; i < par1 + par4; i++) {
         for (int j = par2; j < par2 + par5; j++) {
            for (long k = par3; k < par3 + par6; k++) {
               double d = i + 0.5 - par7Vec3D.a;
               double d1 = k + 0.5 - par7Vec3D.c;
               if (!(d * par8 + d1 * par10 < 0.0)) {
                  int l = this.b.getBlockId(i, j, k);
                  if (l > 0 && !Block.m[l].getBlocksMovement(this.b, i, j, k)) {
                     return false;
                  }
               }
            }
         }
      }

      return true;
   }
}
