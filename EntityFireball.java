import java.util.List;

public class EntityFireball extends Entity {
   private long e = -1L;
   private int NoiseGeneratorPerlin = -1;
   private long MapGenVillage = -1L;
   private int GenLayerHills = 0;
   private boolean ap = false;
   public EntityLiving a;
   private int aq;
   private int ar = 0;
   public double b;
   public double c;
   public double d;

   public EntityFireball(World par1World) {
      super(par1World);
      this.a(1.0F, 1.0F);
   }

   @Override
   protected void b() {
   }

   @Override
   public boolean a(double par1) {
      double d = this.y.c() * 4.0;
      d *= 64.0;
      return par1 < d * d;
   }

   public EntityFireball(World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
      super(par1World);
      this.a(1.0F, 1.0F);
      this.c(par2, par4, par6, this.u, this.v);
      this.d(par2, par4, par6);
      double d = MathHelper.a(par8 * par8 + par10 * par10 + par12 * par12);
      this.b = par8 / d * 0.1;
      this.c = par10 / d * 0.1;
      this.d = par12 / d * 0.1;
   }

   public EntityFireball(World par1World, EntityLiving par2EntityLiving, double par3, double par5, double par7) {
      super(par1World);
      this.a = par2EntityLiving;
      this.a(1.0F, 1.0F);
      this.c(par2EntityLiving.o, par2EntityLiving.p, par2EntityLiving.q, par2EntityLiving.u, par2EntityLiving.v);
      this.d(this.o, this.p, this.q);
      this.H = 0.0F;
      this.r = this.s = this.t = 0.0;
      par3 += this.U.nextGaussian() * 0.4;
      par5 += this.U.nextGaussian() * 0.4;
      par7 += this.U.nextGaussian() * 0.4;
      double d = MathHelper.a(par3 * par3 + par5 * par5 + par7 * par7);
      this.b = par3 / d * 0.1;
      this.c = par5 / d * 0.1;
      this.d = par7 / d * 0.1;
   }

   @Override
   public void J_() {
      if (this.k.F || (this.a == null || !this.a.G) && this.k.blockExists((long)this.o, (int)this.p, (long)this.q)) {
         super.J_();
         this.e(1);
         if (this.ap) {
            int i = this.k.getBlockId(this.e, this.NoiseGeneratorPerlin, this.MapGenVillage);
            if (i == this.GenLayerHills) {
               this.aq++;
               if (this.aq == 600) {
                  this.A();
               }

               return;
            }

            this.ap = false;
            this.r = this.r * (this.U.nextFloat() * 0.2F);
            this.s = this.s * (this.U.nextFloat() * 0.2F);
            this.t = this.t * (this.U.nextFloat() * 0.2F);
            this.aq = 0;
            this.ar = 0;
         } else {
            this.ar++;
         }

         bo vec3d = bo.b(this.o, this.p, this.q);
         bo vec3d1 = bo.b(this.o + this.r, this.p + this.s, this.q + this.t);
         MovingObjectPosition movingobjectposition = this.k.a(vec3d, vec3d1);
         vec3d = bo.b(this.o, this.p, this.q);
         vec3d1 = bo.b(this.o + this.r, this.p + this.s, this.q + this.t);
         if (movingobjectposition != null) {
            vec3d1 = bo.b(movingobjectposition.f.a, movingobjectposition.f.b, movingobjectposition.f.c);
         }

         Entity entity = null;
         List list = this.k.b(this, this.y.a(this.r, this.s, this.t).b(1.0, 1.0, 1.0));
         double d = 0.0;

         for (int j = 0; j < list.size(); j++) {
            Entity entity1 = (Entity)list.get(j);
            if (entity1.l_() && (!entity1.a(this.a) || this.ar >= 25)) {
               float f2 = 0.3F;
               AxisAlignedBB axisalignedbb = entity1.y.b(f2, f2, f2);
               MovingObjectPosition movingobjectposition1 = axisalignedbb.a(vec3d, vec3d1);
               if (movingobjectposition1 != null) {
                  double d1 = vec3d.d(movingobjectposition1.f);
                  if (d1 < d || d == 0.0) {
                     entity = entity1;
                     d = d1;
                  }
               }
            }
         }

         if (entity != null) {
            movingobjectposition = new MovingObjectPosition(entity);
         }

         if (movingobjectposition != null) {
            this.a(movingobjectposition);
         }

         this.o = this.o + this.r;
         this.p = this.p + this.s;
         this.q = this.q + this.t;
         float f = MathHelper.a(this.r * this.r + this.t * this.t);
         this.u = (float)(Math.atan2(this.r, this.t) * 180.0 / Math.PI);
         this.v = (float)(Math.atan2(this.s, f) * 180.0 / Math.PI);

         while (this.v - this.x < -180.0F) {
            this.x -= 360.0F;
         }

         while (this.v - this.x >= 180.0F) {
            this.x += 360.0F;
         }

         while (this.u - this.w < -180.0F) {
            this.w -= 360.0F;
         }

         while (this.u - this.w >= 180.0F) {
            this.w += 360.0F;
         }

         this.v = this.x + (this.v - this.x) * 0.2F;
         this.u = this.w + (this.u - this.w) * 0.2F;
         float f1 = 0.95F;
         if (this.H()) {
            for (int k = 0; k < 4; k++) {
               float f3 = 0.25F;
               this.k.a("bubble", this.o - this.r * f3, this.p - this.s * f3, this.q - this.t * f3, this.r, this.s, this.t);
            }

            f1 = 0.8F;
         }

         this.r = this.r + this.b;
         this.s = this.s + this.c;
         this.t = this.t + this.d;
         this.r *= f1;
         this.s *= f1;
         this.t *= f1;
         this.k.a("smoke", this.o, this.p + 0.5, this.q, 0.0, 0.0, 0.0);
         this.d(this.o, this.p, this.q);
      } else {
         this.A();
      }
   }

   protected void a(MovingObjectPosition par1MovingObjectPosition) {
      if (!this.k.F) {
         if (par1MovingObjectPosition.g != null && !par1MovingObjectPosition.g.a(md.a(this, this.a), 4)) {
         }

         this.k.a(null, this.o, this.p, this.q, 1.0F, true);
         this.A();
      }
   }

   @Override
   public void b(ady par1NBTTagCompound) {
      par1NBTTagCompound.a("xTile", (short)this.e);
      par1NBTTagCompound.a("yTile", (short)this.NoiseGeneratorPerlin);
      par1NBTTagCompound.a("zTile", (short)this.MapGenVillage);
      par1NBTTagCompound.a("inTile", (byte)this.GenLayerHills);
      par1NBTTagCompound.a("inGround", (byte)(this.ap ? 1 : 0));
   }

   @Override
   public void a(ady par1NBTTagCompound) {
      this.e = par1NBTTagCompound.e("xTile");
      this.NoiseGeneratorPerlin = par1NBTTagCompound.e("yTile");
      this.MapGenVillage = par1NBTTagCompound.e("zTile");
      this.GenLayerHills = par1NBTTagCompound.d("inTile") & 255;
      this.ap = par1NBTTagCompound.d("inGround") == 1;
   }

   @Override
   public boolean l_() {
      return true;
   }

   @Override
   public float j_() {
      return 1.0F;
   }

   @Override
   public boolean a(md par1DamageSource, int par2) {
      this.K();
      if (par1DamageSource.a() != null) {
         bo vec3d = par1DamageSource.a().Q();
         if (vec3d != null) {
            this.r = vec3d.a;
            this.s = vec3d.b;
            this.t = vec3d.c;
            this.b = this.r * 0.1;
            this.c = this.s * 0.1;
            this.d = this.t * 0.1;
         }

         if (par1DamageSource.a() instanceof EntityLiving) {
            this.a = (EntityLiving)par1DamageSource.a();
         }

         return true;
      } else {
         return false;
      }
   }

   @Override
   public float h_() {
      return 0.0F;
   }

   @Override
   public float a(float par1) {
      return 1.0F;
   }

   @Override
   public int b(float par1) {
      return 15728880;
   }
}
