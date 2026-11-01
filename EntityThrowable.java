import java.util.List;

public abstract class EntityThrowable extends Entity {
   private long d = -1L;
   private int e = -1;
   private long NoiseGeneratorPerlin = -1L;
   private int MapGenVillage = 0;
   protected boolean a = false;
   public int b = 0;
   protected EntityLiving c;
   private int GenLayerHills;
   private int ap = 0;

   public EntityThrowable(World par1World) {
      super(par1World);
      this.a(0.25F, 0.25F);
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

   public EntityThrowable(World par1World, EntityLiving par2EntityLiving) {
      super(par1World);
      this.c = par2EntityLiving;
      this.a(0.25F, 0.25F);
      this.c(par2EntityLiving.o, par2EntityLiving.p + par2EntityLiving.I(), par2EntityLiving.q, par2EntityLiving.u, par2EntityLiving.v);
      this.o = this.o - MathHelper.b(this.u / 180.0F * (float) Math.PI) * 0.16F;
      this.p -= 0.1F;
      this.q = this.q - MathHelper.a(this.u / 180.0F * (float) Math.PI) * 0.16F;
      this.d(this.o, this.p, this.q);
      this.H = 0.0F;
      float f = 0.4F;
      this.r = -MathHelper.a(this.u / 180.0F * (float) Math.PI) * MathHelper.b(this.v / 180.0F * (float) Math.PI) * f;
      this.t = MathHelper.b(this.u / 180.0F * (float) Math.PI) * MathHelper.b(this.v / 180.0F * (float) Math.PI) * f;
      this.s = -MathHelper.a((this.v + this.d()) / 180.0F * (float) Math.PI) * f;
      this.a(this.r, this.s, this.t, this.c(), 1.0F);
   }

   public EntityThrowable(World par1World, double par2, double par4, double par6) {
      super(par1World);
      this.GenLayerHills = 0;
      this.a(0.25F, 0.25F);
      this.d(par2, par4, par6);
      this.H = 0.0F;
   }

   protected float c() {
      return 1.5F;
   }

   protected float d() {
      return 0.0F;
   }

   public void a(double par1, double par3, double par5, float par7, float par8) {
      float f = MathHelper.a(par1 * par1 + par3 * par3 + par5 * par5);
      par1 /= f;
      par3 /= f;
      par5 /= f;
      par1 += this.U.nextGaussian() * 0.0075F * par8;
      par3 += this.U.nextGaussian() * 0.0075F * par8;
      par5 += this.U.nextGaussian() * 0.0075F * par8;
      par1 *= par7;
      par3 *= par7;
      par5 *= par7;
      this.r = par1;
      this.s = par3;
      this.t = par5;
      float f1 = MathHelper.a(par1 * par1 + par5 * par5);
      this.w = this.u = (float)(Math.atan2(par1, par5) * 180.0 / Math.PI);
      this.x = this.v = (float)(Math.atan2(par3, f1) * 180.0 / Math.PI);
      this.GenLayerHills = 0;
   }

   @Override
   public void a(double par1, double par3, double par5) {
      this.r = par1;
      this.s = par3;
      this.t = par5;
      if (this.x == 0.0F && this.w == 0.0F) {
         float f = MathHelper.a(par1 * par1 + par5 * par5);
         this.w = this.u = (float)(Math.atan2(par1, par5) * 180.0 / Math.PI);
         this.x = this.v = (float)(Math.atan2(par3, f) * 180.0 / Math.PI);
      }
   }

   @Override
   public void J_() {
      this.N = this.o;
      this.O = this.p;
      this.P = this.q;
      super.J_();
      if (this.b > 0) {
         this.b--;
      }

      if (this.a) {
         int i = this.k.getBlockId(this.d, this.e, this.NoiseGeneratorPerlin);
         if (i == this.MapGenVillage) {
            this.GenLayerHills++;
            if (this.GenLayerHills == 1200) {
               this.A();
            }

            return;
         }

         this.a = false;
         this.r = this.r * (this.U.nextFloat() * 0.2F);
         this.s = this.s * (this.U.nextFloat() * 0.2F);
         this.t = this.t * (this.U.nextFloat() * 0.2F);
         this.GenLayerHills = 0;
         this.ap = 0;
      } else {
         this.ap++;
      }

      bo vec3d = bo.b(this.o, this.p, this.q);
      bo vec3d1 = bo.b(this.o + this.r, this.p + this.s, this.q + this.t);
      MovingObjectPosition movingobjectposition = this.k.a(vec3d, vec3d1);
      vec3d = bo.b(this.o, this.p, this.q);
      vec3d1 = bo.b(this.o + this.r, this.p + this.s, this.q + this.t);
      if (movingobjectposition != null) {
         vec3d1 = bo.b(movingobjectposition.f.a, movingobjectposition.f.b, movingobjectposition.f.c);
      }

      if (!this.k.F) {
         Entity entity = null;
         List list = this.k.b(this, this.y.a(this.r, this.s, this.t).b(1.0, 1.0, 1.0));
         double d = 0.0;

         for (int k = 0; k < list.size(); k++) {
            Entity entity1 = (Entity)list.get(k);
            if (entity1.l_() && (entity1 != this.c || this.ap >= 5)) {
               float f4 = 0.3F;
               AxisAlignedBB axisalignedbb = entity1.y.b(f4, f4, f4);
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
      double f1 = 0.99;
      float f2 = this.e();
      if (this.H()) {
         for (int j = 0; j < 4; j++) {
            float f3 = 0.25F;
            this.k.a("bubble", this.o - this.r * f3, this.p - this.s * f3, this.q - this.t * f3, this.r, this.s, this.t);
         }

         f1 = 0.8;
      }

      this.r *= f1;
      this.s *= f1;
      this.t *= f1;
      this.s -= f2;
      this.d(this.o, this.p, this.q);
   }

   protected float e() {
      return 0.03F;
   }

   protected abstract void a(MovingObjectPosition var1);

   @Override
   public void b(ady par1NBTTagCompound) {
      par1NBTTagCompound.a("xTile", (short)this.d);
      par1NBTTagCompound.a("yTile", (short)this.e);
      par1NBTTagCompound.a("zTile", (short)this.NoiseGeneratorPerlin);
      par1NBTTagCompound.a("inTile", (byte)this.MapGenVillage);
      par1NBTTagCompound.a("shake", (byte)this.b);
      par1NBTTagCompound.a("inGround", (byte)(this.a ? 1 : 0));
   }

   @Override
   public void a(ady par1NBTTagCompound) {
      this.d = par1NBTTagCompound.e("xTile");
      this.e = par1NBTTagCompound.e("yTile");
      this.NoiseGeneratorPerlin = par1NBTTagCompound.e("zTile");
      this.MapGenVillage = par1NBTTagCompound.d("inTile") & 255;
      this.b = par1NBTTagCompound.d("shake") & 255;
      this.a = par1NBTTagCompound.d("inGround") == 1;
   }

   @Override
   public void a(EntityPlayer entityplayer) {
   }

   @Override
   public float h_() {
      return 0.0F;
   }
}
