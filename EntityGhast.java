public class EntityGhast extends EntityFlying implements xf {
   public int a = 0;
   public double b;
   public double c;
   public double d;
   private Entity MapGenVillage = null;
   private int GenLayerHills = 0;
   public int e = 0;
   public int NoiseGeneratorPerlin = 0;

   public EntityGhast(World par1World) {
      super(par1World);
      this.bm = "/mob/ghast.png";
      this.a(4.0F, 4.0F);
      this.ab = true;
      this.bI = 5;
      this.b = this.o;
      this.c = this.p;
      this.d = this.q;
   }

   @Override
   public boolean a(md par1DamageSource, int par2) {
      if ("fireball".equals(par1DamageSource.l()) && par1DamageSource.a() instanceof EntityPlayer) {
         super.a(par1DamageSource, 1000);
         ((EntityPlayer)par1DamageSource.a()).a(dp.y);
         return true;
      } else {
         return super.a(par1DamageSource, par2);
      }
   }

   @Override
   protected void b() {
      super.b();
      this.EntityNoteFX.a(16, (byte)0);
   }

   @Override
   public int d() {
      return 10;
   }

   @Override
   public void J_() {
      super.J_();
      byte byte0 = this.EntityNoteFX.a(16);
      this.bm = byte0 != 1 ? "/mob/ghast.png" : "/mob/ghast_fire.png";
   }

   @Override
   protected void y_() {
      if (!this.k.F && this.k.q == 0) {
         this.A();
      }

      this.w();
      this.e = this.NoiseGeneratorPerlin;
      double d = this.b - this.o;
      double d1 = this.c - this.p;
      double d2 = this.d - this.q;
      double d3 = MathHelper.a(d * d + d1 * d1 + d2 * d2);
      if (d3 < 1.0 || d3 > 60.0) {
         this.b = this.o + (this.U.nextFloat() * 2.0F - 1.0F) * 16.0F;
         this.c = this.p + (this.U.nextFloat() * 2.0F - 1.0F) * 16.0F;
         this.d = this.q + (this.U.nextFloat() * 2.0F - 1.0F) * 16.0F;
         d = this.b - this.o;
         d1 = this.c - this.p;
         d2 = this.d - this.q;
         d3 = MathHelper.a(d * d + d1 * d1 + d2 * d2);
      }

      if (this.a-- <= 0) {
         this.a = this.a + this.U.nextInt(5) + 2;
         if (this.a(this.b, this.c, this.d, d3)) {
            this.r += d / d3 * 0.1;
            this.s += d1 / d3 * 0.1;
            this.t += d2 / d3 * 0.1;
         } else {
            this.b = this.o;
            this.c = this.p;
            this.d = this.q;
         }
      }

      if (this.MapGenVillage != null && this.MapGenVillage.G) {
         this.MapGenVillage = null;
      }

      if (this.MapGenVillage == null || this.GenLayerHills-- <= 0) {
         this.MapGenVillage = this.k.b(this, 100.0);
         if (this.MapGenVillage != null) {
            this.GenLayerHills = 20;
         }
      }

      double d4 = 64.0;
      if (this.MapGenVillage != null && this.MapGenVillage.f(this) < d4 * d4) {
         double d5 = this.MapGenVillage.o - this.o;
         double d6 = this.MapGenVillage.y.b + this.MapGenVillage.J / 2.0F - (this.p + this.J / 2.0F);
         double d7 = this.MapGenVillage.q - this.q;
         this.bd = this.u = -((float)Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;
         if (this.m(this.MapGenVillage)) {
            if (this.NoiseGeneratorPerlin == 10) {
               this.k.playAuxSFXAtEntity(null, 1007, (long)this.o, (int)this.p, (long)this.q, 0);
            }

            this.NoiseGeneratorPerlin++;
            if (this.NoiseGeneratorPerlin == 20) {
               this.k.playAuxSFXAtEntity(null, 1008, (long)this.o, (int)this.p, (long)this.q, 0);
               EntityFireball entityfireball = new EntityFireball(this.k, this, d5, d6, d7);
               double d8 = 4.0;
               bo vec3d = this.k(1.0F);
               entityfireball.o = this.o + vec3d.a * d8;
               entityfireball.p = this.p + this.J / 2.0F + 0.5;
               entityfireball.q = this.q + vec3d.c * d8;
               this.k.a(entityfireball);
               this.NoiseGeneratorPerlin = -40;
            }
         } else if (this.NoiseGeneratorPerlin > 0) {
            this.NoiseGeneratorPerlin--;
         }
      } else {
         this.bd = this.u = -((float)Math.atan2(this.r, this.t)) * 180.0F / (float) Math.PI;
         if (this.NoiseGeneratorPerlin > 0) {
            this.NoiseGeneratorPerlin--;
         }
      }

      if (!this.k.F) {
         byte byte0 = this.EntityNoteFX.a(16);
         byte byte1 = (byte)(this.NoiseGeneratorPerlin <= 10 ? 0 : 1);
         if (byte0 != byte1) {
            this.EntityNoteFX.b(16, byte1);
         }
      }
   }

   private boolean a(double par1, double par3, double par5, double par7) {
      double d = (this.b - this.o) / par7;
      double d1 = (this.c - this.p) / par7;
      double d2 = (this.d - this.q) / par7;
      AxisAlignedBB axisalignedbb = this.y.d();

      for (int i = 1; i < par7; i++) {
         axisalignedbb.d(d, d1, d2);
         if (this.k.a(this, axisalignedbb).size() > 0) {
            return false;
         }
      }

      return true;
   }

   @Override
   protected String m() {
      return "mob.ghast.moan";
   }

   @Override
   protected String n() {
      return "mob.ghast.scream";
   }

   @Override
   protected String o() {
      return "mob.ghast.death";
   }

   @Override
   protected int f() {
      return Item.M.bQ;
   }

   @Override
   protected void a(boolean par1, int par2) {
      int i = this.U.nextInt(2) + this.U.nextInt(1 + par2);

      for (int j = 0; j < i; j++) {
         this.b(Item.EntityAIMoveIndoors.bQ, 1);
      }

      i = this.U.nextInt(3) + this.U.nextInt(1 + par2);

      for (int k = 0; k < i; k++) {
         this.b(Item.M.bQ, 1);
      }
   }

   @Override
   protected float C_() {
      return 10.0F;
   }

   @Override
   public boolean i() {
      return this.U.nextInt(20) == 0 && super.i() && this.k.q > 0;
   }

   @Override
   public int EntityNoteFX() {
      return 1;
   }
}
