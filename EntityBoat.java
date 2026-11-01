import java.util.List;

public class EntityBoat extends Entity {
   private int a;
   private double b;
   private double c;
   private double d;
   private double e;
   private double NoiseGeneratorPerlin;
   private double MapGenVillage;
   private double GenLayerHills;
   private double ap;

   public EntityBoat(World par1World) {
      super(par1World);
      this.h = true;
      this.a(1.5F, 0.6F);
      this.H = this.J / 2.0F;
   }

   @Override
   protected boolean e_() {
      return false;
   }

   @Override
   protected void b() {
      this.EntityNoteFX.a(17, new Integer(0));
      this.EntityNoteFX.a(18, new Integer(1));
      this.EntityNoteFX.a(19, new Integer(0));
   }

   @Override
   public AxisAlignedBB b(Entity par1Entity) {
      return par1Entity.y;
   }

   @Override
   public AxisAlignedBB f_() {
      return this.y;
   }

   @Override
   public boolean d_() {
      return true;
   }

   public EntityBoat(World par1World, double par2, double par4, double par6) {
      this(par1World);
      this.d(par2, par4 + this.H, par6);
      this.r = 0.0;
      this.s = 0.0;
      this.t = 0.0;
      this.l = par2;
      this.m = par4;
      this.n = par6;
   }

   @Override
   public double l() {
      return this.J * 0.0 - 0.3F;
   }

   @Override
   public boolean a(md par1DamageSource, int par2) {
      if (!this.k.F && !this.G) {
         this.d(-this.p());
         this.c(10);
         this.b(this.n() + par2 * 10);
         this.K();
         if (this.n() > 40) {
            if (this.i != null) {
               this.i.h(this);
            }

            for (int i = 0; i < 3; i++) {
               this.a(Block.x.bO, 1, 0.0F);
            }

            for (int j = 0; j < 2; j++) {
               this.a(Item.D.bQ, 1, 0.0F);
            }

            this.A();
         }

         return true;
      } else {
         return true;
      }
   }

   @Override
   public void k() {
      this.d(-this.p());
      this.c(10);
      this.b(this.n() * 11);
   }

   @Override
   public boolean l_() {
      return !this.G;
   }

   @Override
   public void a(double par1, double par3, double par5, float par7, float par8, int par9) {
      this.b = par1;
      this.c = par3;
      this.d = par5;
      this.e = par7;
      this.NoiseGeneratorPerlin = par8;
      this.a = par9 + 4;
      this.r = this.MapGenVillage;
      this.s = this.GenLayerHills;
      this.t = this.ap;
   }

   @Override
   public void a(double par1, double par3, double par5) {
      this.MapGenVillage = this.r = par1;
      this.GenLayerHills = this.s = par3;
      this.ap = this.t = par5;
   }

   @Override
   public void J_() {
      super.J_();
      if (this.o() > 0) {
         this.c(this.o() - 1);
      }

      if (this.n() > 0) {
         this.b(this.n() - 1);
      }

      this.l = this.o;
      this.m = this.p;
      this.n = this.q;
      int i = 5;
      double d = 0.0;

      for (int j = 0; j < i; j++) {
         double d2 = this.y.b + (this.y.e - this.y.b) * (j + 0) / i - 0.125;
         double d8 = this.y.b + (this.y.e - this.y.b) * (j + 1) / i - 0.125;
         AxisAlignedBB axisalignedbb = AxisAlignedBB.b(this.y.a, d2, this.y.c, this.y.d, d8, this.y.f);
         if (this.k.b(axisalignedbb, acn.g)) {
            d += 1.0 / i;
         }
      }

      double d1 = Math.sqrt(this.r * this.r + this.t * this.t);
      if (d1 > 0.15) {
         double d3 = Math.cos(this.u * Math.PI / 180.0);
         double d9 = Math.sin(this.u * Math.PI / 180.0);

         for (int i1 = 0; i1 < 1.0 + d1 * 60.0; i1++) {
            double d16 = this.U.nextFloat() * 2.0F - 1.0F;
            double d19 = (this.U.nextInt(2) * 2 - 1) * 0.7;
            if (this.U.nextBoolean()) {
               double d21 = this.o - d3 * d16 * 0.8 + d9 * d19;
               double d23 = this.q - d9 * d16 * 0.8 - d3 * d19;
               this.k.a("splash", d21, this.p - 0.125, d23, this.r, this.s, this.t);
            } else {
               double d22 = this.o + d3 + d9 * d16 * 0.7;
               double d24 = this.q + d9 - d3 * d16 * 0.7;
               this.k.a("splash", d22, this.p - 0.125, d24, this.r, this.s, this.t);
            }
         }
      }

      if (this.k.F) {
         if (this.a > 0) {
            double d4 = this.o + (this.b - this.o) / this.a;
            double d10 = this.p + (this.c - this.p) / this.a;
            double d13 = this.q + (this.d - this.q) / this.a;
            double d17 = this.e - this.u;

            while (d17 < -180.0) {
               d17 += 360.0;
            }

            while (d17 >= 180.0) {
               d17 -= 360.0;
            }

            this.u = (float)(this.u + d17 / this.a);
            this.v = (float)(this.v + (this.NoiseGeneratorPerlin - this.v) / this.a);
            this.a--;
            this.d(d4, d10, d13);
            this.b(this.u, this.v);
         } else {
            double d5 = this.o + this.r;
            double d11 = this.p + this.s;
            double d14 = this.q + this.t;
            this.d(d5, d11, d14);
            if (this.z) {
               this.r *= 0.5;
               this.s *= 0.5;
               this.t *= 0.5;
            }

            this.r *= 0.99F;
            this.s *= 0.95F;
            this.t *= 0.99F;
         }
      } else {
         if (d < 1.0) {
            double d6 = d * 2.0 - 1.0;
            this.s += 0.04F * d6;
         } else {
            if (this.s < 0.0) {
               this.s /= 2.0;
            }

            this.s += 0.007F;
         }

         if (this.i != null) {
            this.r = this.r + this.i.r * 0.2;
            this.t = this.t + this.i.t * 0.2;
         }

         double d7 = 0.4;
         if (this.r < -d7) {
            this.r = -d7;
         }

         if (this.r > d7) {
            this.r = d7;
         }

         if (this.t < -d7) {
            this.t = -d7;
         }

         if (this.t > d7) {
            this.t = d7;
         }

         if (this.z) {
            this.r *= 0.5;
            this.s *= 0.5;
            this.t *= 0.5;
         }

         this.b(this.r, this.s, this.t);
         if (!this.A || !(d1 > 0.2)) {
            this.r *= 0.99F;
            this.s *= 0.95F;
            this.t *= 0.99F;
         } else if (!this.k.F) {
            this.A();

            for (int k = 0; k < 3; k++) {
               this.a(Block.x.bO, 1, 0.0F);
            }

            for (int l = 0; l < 2; l++) {
               this.a(Item.D.bQ, 1, 0.0F);
            }
         }

         this.v = 0.0F;
         double d12 = this.u;
         double d15 = this.l - this.o;
         double d18 = this.n - this.q;
         if (d15 * d15 + d18 * d18 > 0.001) {
            d12 = (float)(Math.atan2(d18, d15) * 180.0 / Math.PI);
         }

         double d20 = d12 - this.u;

         while (d20 >= 180.0) {
            d20 -= 360.0;
         }

         while (d20 < -180.0) {
            d20 += 360.0;
         }

         if (d20 > 20.0) {
            d20 = 20.0;
         }

         if (d20 < -20.0) {
            d20 = -20.0;
         }

         this.u = (float)(this.u + d20);
         this.b(this.u, this.v);
         List list = this.k.b(this, this.y.b(0.2F, 0.0, 0.2F));
         if (list != null && list.size() > 0) {
            for (int j1 = 0; j1 < list.size(); j1++) {
               Entity entity = (Entity)list.get(j1);
               if (entity != this.i && entity.d_() && entity instanceof EntityBoat) {
                  entity.g(this);
               }
            }
         }

         for (int k1 = 0; k1 < 4; k1++) {
            long l1 = MathHelper.d(this.o + (k1 % 2 - 0.5) * 0.8);
            int i2 = MathHelper.c(this.p);
            long j2 = MathHelper.d(this.q + (k1 / 2 - 0.5) * 0.8);
            if (this.k.getBlockId(l1, i2, j2) == Block.aS.bO) {
               this.k.setBlockWithNotify(l1, i2, j2, 0);
            }
         }

         if (this.i != null && this.i.G) {
            this.i = null;
         }
      }
   }

   @Override
   public void i_() {
      if (this.i != null) {
         double d = Math.cos(this.u * Math.PI / 180.0) * 0.4;
         double d1 = Math.sin(this.u * Math.PI / 180.0) * 0.4;
         this.i.d(this.o + d, this.p + this.l() + this.i.P(), this.q + d1);
      }
   }

   @Override
   protected void b(ady nbttagcompound) {
   }

   @Override
   protected void a(ady nbttagcompound) {
   }

   @Override
   public float h_() {
      return 0.0F;
   }

   @Override
   public boolean c(EntityPlayer par1EntityPlayer) {
      if (this.i != null && this.i instanceof EntityPlayer && this.i != par1EntityPlayer) {
         return true;
      }

      if (!this.k.F) {
         par1EntityPlayer.h(this);
      }

      return true;
   }

   public void b(int par1) {
      this.EntityNoteFX.b(19, par1);
   }

   public int n() {
      return this.EntityNoteFX.c(19);
   }

   public void c(int par1) {
      this.EntityNoteFX.b(17, par1);
   }

   public int o() {
      return this.EntityNoteFX.c(17);
   }

   public void d(int par1) {
      this.EntityNoteFX.b(18, par1);
   }

   public int p() {
      return this.EntityNoteFX.c(18);
   }
}
