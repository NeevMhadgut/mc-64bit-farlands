public abstract class EntityCreature extends EntityLiving {
   private PathEntity a;
   protected Entity GenLayerHills;
   protected boolean ap = false;
   protected int aq = 0;

   public EntityCreature(World par1World) {
      super(par1World);
   }

   protected boolean MapGenVillage() {
      return false;
   }

   @Override
   protected void y_() {
      lv.a("ai");
      if (this.aq > 0) {
         this.aq--;
      }

      this.ap = this.MapGenVillage();
      float f = 16.0F;
      if (this.GenLayerHills == null) {
         this.GenLayerHills = this.h();
         if (this.GenLayerHills != null) {
            this.a = this.k.a(this, this.GenLayerHills, f, true, false, false, true);
         }
      } else if (!this.GenLayerHills.M()) {
         this.GenLayerHills = null;
      } else {
         float f1 = this.GenLayerHills.e(this);
         if (this.m(this.GenLayerHills)) {
            this.a(this.GenLayerHills, f1);
         } else {
            this.b(this.GenLayerHills, f1);
         }
      }

      lv.b();
      if (this.ap || this.GenLayerHills == null || this.a != null && this.U.nextInt(20) != 0) {
         if (!this.ap && (this.a == null && this.U.nextInt(180) == 0 || this.U.nextInt(120) == 0 || this.aq > 0) && this.cd < 100) {
            this.ap();
         }
      } else {
         this.a = this.k.a(this, this.GenLayerHills, f, true, false, false, true);
      }

      int i = MathHelper.c(this.y.b + 0.5);
      boolean flag = this.H();
      boolean flag1 = this.J();
      this.v = 0.0F;
      if (this.a != null && this.U.nextInt(100) != 0) {
         lv.a("followpath");
         bo vec3d = this.a.a(this);
         double d = this.I * 2.0F;

         while (vec3d != null && vec3d.d(this.o, vec3d.b, this.q) < d * d) {
            this.a.a();
            if (this.a.b()) {
               vec3d = null;
               this.a = null;
            } else {
               vec3d = this.a.a(this);
            }
         }

         this.ch = false;
         if (vec3d != null) {
            d = vec3d.a - this.o;
            double d2 = vec3d.c - this.q;
            double d3 = vec3d.b - i;
            float f2 = (float)(Math.atan2(d2, d) * 180.0 / Math.PI) - 90.0F;
            float f3 = f2 - this.u;
            this.cf = this.TileEntityMobSpawner;

            while (f3 < -180.0F) {
               f3 += 360.0F;
            }

            while (f3 >= 180.0F) {
               f3 -= 360.0F;
            }

            if (f3 > 30.0F) {
               f3 = 30.0F;
            }

            if (f3 < -30.0F) {
               f3 = -30.0F;
            }

            this.u += f3;
            if (this.ap && this.GenLayerHills != null) {
               double d4 = this.GenLayerHills.o - this.o;
               double d5 = this.GenLayerHills.q - this.q;
               float f5 = this.u;
               this.u = (float)(Math.atan2(d5, d4) * 180.0 / Math.PI) - 90.0F;
               float f4 = (f5 - this.u + 90.0F) * (float) Math.PI / 180.0F;
               this.ce = -MathHelper.a(f4) * this.cf * 1.0F;
               this.cf = MathHelper.b(f4) * this.cf * 1.0F;
            }

            if (d3 > 0.0) {
               this.ch = true;
            }
         }

         if (this.GenLayerHills != null) {
            this.a(this.GenLayerHills, 30.0F, 30.0F);
         }

         if (this.A && !this.ar()) {
            this.ch = true;
         }

         if (this.U.nextFloat() < 0.8F && (flag || flag1)) {
            this.ch = true;
         }

         lv.b();
      } else {
         super.y_();
         this.a = null;
      }
   }

   protected void ap() {
      lv.a("stroll");
      boolean flag = false;
      long i = -1L;
      int j = -1;
      long k = -1L;
      float f = -99999.0F;

      for (int l = 0; l < 10; l++) {
         long i1 = MathHelper.d(this.o + this.U.nextInt(13) - 6.0);
         int j1 = MathHelper.c(this.p + this.U.nextInt(7) - 3.0);
         long k1 = MathHelper.d(this.q + this.U.nextInt(13) - 6.0);
         float f1 = this.getBlockPathWeight(i1, j1, k1);
         if (f1 > f) {
            f = f1;
            i = i1;
            j = j1;
            k = k1;
            flag = true;
         }
      }

      if (flag) {
         this.a = this.k.getEntityPathToXYZ(this, i, j, k, 10.0F, true, false, false, true);
      }

      lv.b();
   }

   protected void a(Entity entity, float f) {
   }

   protected void b(Entity entity, float f) {
   }

   public float getBlockPathWeight(long par1, int par2, long par3) {
      return 0.0F;
   }

   protected Entity h() {
      return null;
   }

   @Override
   public boolean i() {
      long i = MathHelper.d(this.o);
      int j = MathHelper.c(this.y.b);
      long k = MathHelper.d(this.q);
      return super.i() && this.getBlockPathWeight(i, j, k) >= 0.0F;
   }

   public boolean ar() {
      return this.a != null;
   }

   public void a(PathEntity par1PathEntity) {
      this.a = par1PathEntity;
   }

   public Entity as() {
      return this.GenLayerHills;
   }

   public void i(Entity par1Entity) {
      this.GenLayerHills = par1Entity;
   }

   @Override
   protected float at() {
      if (this.b_()) {
         return 1.0F;
      }

      float f = super.at();
      if (this.aq > 0) {
         f *= 2.0F;
      }

      return f;
   }
}
