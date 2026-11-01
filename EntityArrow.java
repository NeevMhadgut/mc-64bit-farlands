import java.util.List;

public class EntityArrow extends Entity {
   private long e = -1L;
   private int NoiseGeneratorPerlin = -1;
   private long MapGenVillage = -1L;
   private int GenLayerHills = 0;
   private int ap = 0;
   private boolean aq = false;
   public boolean a = false;
   public int b = 0;
   public Entity c;
   private int ar;
   private int as = 0;
   private double at = 2.0;
   private int au;
   public boolean d = false;

   public EntityArrow(World par1World) {
      super(par1World);
      this.a(0.5F, 0.5F);
   }

   public EntityArrow(World par1World, double par2, double par4, double par6) {
      super(par1World);
      this.a(0.5F, 0.5F);
      this.d(par2, par4, par6);
      this.H = 0.0F;
   }

   public EntityArrow(World par1World, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving, float par4, float par5) {
      super(par1World);
      this.c = par2EntityLiving;
      this.a = par2EntityLiving instanceof EntityPlayer;
      this.p = par2EntityLiving.p + par2EntityLiving.I() - 0.1F;
      double d = par3EntityLiving.o - par2EntityLiving.o;
      double d1 = par3EntityLiving.p + par3EntityLiving.I() - 0.7F - this.p;
      double d2 = par3EntityLiving.q - par2EntityLiving.q;
      double d3 = MathHelper.a(d * d + d2 * d2);
      if (!(d3 < 1.0E-7)) {
         float f = (float)(Math.atan2(d2, d) * 180.0 / Math.PI) - 90.0F;
         float f1 = (float)(-(Math.atan2(d1, d3) * 180.0 / Math.PI));
         double d4 = d / d3;
         double d5 = d2 / d3;
         this.c(par2EntityLiving.o + d4, this.p, par2EntityLiving.q + d5, f, f1);
         this.H = 0.0F;
         float f2 = (float)d3 * 0.2F;
         this.a(d, d1 + f2, d2, par4, par5);
      }
   }

   public EntityArrow(World par1World, EntityLiving par2EntityLiving, float par3) {
      super(par1World);
      this.c = par2EntityLiving;
      this.a = par2EntityLiving instanceof EntityPlayer;
      this.a(0.5F, 0.5F);
      this.c(par2EntityLiving.o, par2EntityLiving.p + par2EntityLiving.I(), par2EntityLiving.q, par2EntityLiving.u, par2EntityLiving.v);
      this.o = this.o - MathHelper.b(this.u / 180.0F * (float) Math.PI) * 0.16F;
      this.p -= 0.1F;
      this.q = this.q - MathHelper.a(this.u / 180.0F * (float) Math.PI) * 0.16F;
      this.d(this.o, this.p, this.q);
      this.H = 0.0F;
      this.r = -MathHelper.a(this.u / 180.0F * (float) Math.PI) * MathHelper.b(this.v / 180.0F * (float) Math.PI);
      this.t = MathHelper.b(this.u / 180.0F * (float) Math.PI) * MathHelper.b(this.v / 180.0F * (float) Math.PI);
      this.s = -MathHelper.a(this.v / 180.0F * (float) Math.PI);
      this.a(this.r, this.s, this.t, par3 * 1.5F, 1.0F);
   }

   @Override
   protected void b() {
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
      this.ar = 0;
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
         this.x = this.v;
         this.w = this.u;
         this.c(this.o, this.p, this.q, this.u, this.v);
         this.ar = 0;
      }
   }

   @Override
   public void J_() {
      super.J_();
      if (this.x == 0.0F && this.w == 0.0F) {
         float f = MathHelper.a(this.r * this.r + this.t * this.t);
         this.w = this.u = (float)(Math.atan2(this.r, this.t) * 180.0 / Math.PI);
         this.x = this.v = (float)(Math.atan2(this.s, f) * 180.0 / Math.PI);
      }

      int i = this.k.getBlockId(this.e, this.NoiseGeneratorPerlin, this.MapGenVillage);
      if (i > 0) {
         Block.m[i].setBlockBoundsBasedOnState(this.k, this.e, this.NoiseGeneratorPerlin, this.MapGenVillage);
         AxisAlignedBB axisalignedbb = Block.m[i].getCollisionBoundingBoxFromPool(this.k, this.e, this.NoiseGeneratorPerlin, this.MapGenVillage);
         if (axisalignedbb != null && axisalignedbb.a(bo.b(this.o, this.p, this.q))) {
            this.aq = true;
         }
      }

      if (this.b > 0) {
         this.b--;
      }

      if (this.aq) {
         int j = this.k.getBlockId(this.e, this.NoiseGeneratorPerlin, this.MapGenVillage);
         int k = this.k.getBlockMetadata(this.e, this.NoiseGeneratorPerlin, this.MapGenVillage);
         if (j == this.GenLayerHills && k == this.ap) {
            this.ar++;
            if (this.ar == 1200) {
               this.A();
            }
         } else {
            this.aq = false;
            this.r = this.r * (this.U.nextFloat() * 0.2F);
            this.s = this.s * (this.U.nextFloat() * 0.2F);
            this.t = this.t * (this.U.nextFloat() * 0.2F);
            this.ar = 0;
            this.as = 0;
         }
      } else {
         this.as++;
         bo vec3d = bo.b(this.o, this.p, this.q);
         bo vec3d1 = bo.b(this.o + this.r, this.p + this.s, this.q + this.t);
         MovingObjectPosition movingobjectposition = this.k.a(vec3d, vec3d1, false, true);
         vec3d = bo.b(this.o, this.p, this.q);
         vec3d1 = bo.b(this.o + this.r, this.p + this.s, this.q + this.t);
         if (movingobjectposition != null) {
            vec3d1 = bo.b(movingobjectposition.f.a, movingobjectposition.f.b, movingobjectposition.f.c);
         }

         Entity entity = null;
         List list = this.k.b(this, this.y.a(this.r, this.s, this.t).b(1.0, 1.0, 1.0));
         double d = 0.0;

         for (int l = 0; l < list.size(); l++) {
            Entity entity1 = (Entity)list.get(l);
            if (entity1.l_() && (entity1 != this.c || this.as >= 5)) {
               float f5 = 0.3F;
               AxisAlignedBB axisalignedbb1 = entity1.y.b(f5, f5, f5);
               MovingObjectPosition movingobjectposition1 = axisalignedbb1.a(vec3d, vec3d1);
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
            if (movingobjectposition.g != null) {
               float f1 = MathHelper.a(this.r * this.r + this.s * this.s + this.t * this.t);
               int j1 = (int)Math.ceil(f1 * this.at);
               if (this.d) {
                  j1 += this.U.nextInt(j1 / 2 + 2);
               }

               md damagesource = null;
               if (this.c == null) {
                  damagesource = md.a(this, this);
               } else {
                  damagesource = md.a(this, this.c);
               }

               if (this.T()) {
                  movingobjectposition.g.e(5);
               }

               if (movingobjectposition.g.a(damagesource, j1)) {
                  if (movingobjectposition.g instanceof EntityLiving) {
                     ((EntityLiving)movingobjectposition.g).bQ++;
                     if (this.au > 0) {
                        float f7 = MathHelper.a(this.r * this.r + this.t * this.t);
                        if (f7 > 0.0F) {
                           movingobjectposition.g.c(this.r * this.au * 0.6F / f7, 0.1, this.t * this.au * 0.6F / f7);
                        }
                     }
                  }

                  this.k.a(this, "random.bowhit", 1.0F, 1.2F / (this.U.nextFloat() * 0.2F + 0.9F));
                  this.A();
               } else {
                  this.r *= -0.1F;
                  this.s *= -0.1F;
                  this.t *= -0.1F;
                  this.u += 180.0F;
                  this.w += 180.0F;
                  this.as = 0;
               }
            } else {
               this.e = movingobjectposition.b;
               this.NoiseGeneratorPerlin = movingobjectposition.c;
               this.MapGenVillage = movingobjectposition.d;
               this.GenLayerHills = this.k.getBlockId(this.e, this.NoiseGeneratorPerlin, this.MapGenVillage);
               this.ap = this.k.getBlockMetadata(this.e, this.NoiseGeneratorPerlin, this.MapGenVillage);
               this.r = (float)(movingobjectposition.f.a - this.o);
               this.s = (float)(movingobjectposition.f.b - this.p);
               this.t = (float)(movingobjectposition.f.c - this.q);
               float f2 = MathHelper.a(this.r * this.r + this.s * this.s + this.t * this.t);
               this.o = this.o - this.r / f2 * 0.05F;
               this.p = this.p - this.s / f2 * 0.05F;
               this.q = this.q - this.t / f2 * 0.05F;
               this.k.a(this, "random.bowhit", 1.0F, 1.2F / (this.U.nextFloat() * 0.2F + 0.9F));
               this.aq = true;
               this.b = 7;
               this.d = false;
            }
         }

         if (this.d) {
            for (int i1 = 0; i1 < 4; i1++) {
               this.k.a("crit", this.o + this.r * i1 / 4.0, this.p + this.s * i1 / 4.0, this.q + this.t * i1 / 4.0, -this.r, -this.s + 0.2, -this.t);
            }
         }

         this.o = this.o + this.r;
         this.p = this.p + this.s;
         this.q = this.q + this.t;
         float f3 = MathHelper.a(this.r * this.r + this.t * this.t);
         this.u = (float)(Math.atan2(this.r, this.t) * 180.0 / Math.PI);
         this.v = (float)(Math.atan2(this.s, f3) * 180.0 / Math.PI);

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
         float f4 = 0.99F;
         float f6 = 0.05F;
         if (this.H()) {
            for (int k1 = 0; k1 < 4; k1++) {
               float f8 = 0.25F;
               this.k.a("bubble", this.o - this.r * f8, this.p - this.s * f8, this.q - this.t * f8, this.r, this.s, this.t);
            }

            f4 = 0.8F;
         }

         this.r *= f4;
         this.s *= f4;
         this.t *= f4;
         this.s -= f6;
         this.d(this.o, this.p, this.q);
      }
   }

   @Override
   public void b(ady par1NBTTagCompound) {
      par1NBTTagCompound.a("xTile", this.e);
      par1NBTTagCompound.a("yTile", (short)this.NoiseGeneratorPerlin);
      par1NBTTagCompound.a("zTile", this.MapGenVillage);
      par1NBTTagCompound.a("inTile", (byte)this.GenLayerHills);
      par1NBTTagCompound.a("inData", (byte)this.ap);
      par1NBTTagCompound.a("shake", (byte)this.b);
      par1NBTTagCompound.a("inGround", (byte)(this.aq ? 1 : 0));
      par1NBTTagCompound.a("player", this.a);
      par1NBTTagCompound.a("damage", this.at);
   }

   @Override
   public void a(ady par1NBTTagCompound) {
      try {
         this.e = par1NBTTagCompound.g("xTile");
      } catch (ClassCastException ex) {
         this.e = par1NBTTagCompound.e("xTile");
      }

      this.NoiseGeneratorPerlin = par1NBTTagCompound.e("yTile");

      try {
         this.MapGenVillage = par1NBTTagCompound.g("zTile");
      } catch (ClassCastException ex) {
         this.MapGenVillage = par1NBTTagCompound.e("zTile");
      }

      if ((long)this.o != this.e) {
         this.e = (long)this.o;
      }

      if ((long)this.q != this.MapGenVillage) {
         this.MapGenVillage = (long)this.q;
      }

      this.GenLayerHills = par1NBTTagCompound.d("inTile") & 255;
      this.ap = par1NBTTagCompound.d("inData") & 255;
      this.b = par1NBTTagCompound.d("shake") & 255;
      this.aq = par1NBTTagCompound.d("inGround") == 1;
      this.a = par1NBTTagCompound.o("player");
      if (par1NBTTagCompound.c("damage")) {
         this.at = par1NBTTagCompound.i("damage");
      }
   }

   @Override
   public void a(EntityPlayer par1EntityPlayer) {
      if (!this.k.F) {
         if (this.aq && this.a && this.b <= 0 && par1EntityPlayer.ap.a(new ItemStack(Item.l, 1))) {
            this.k.a(this, "random.pop", 0.2F, ((this.U.nextFloat() - this.U.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            par1EntityPlayer.b(this, 1);
            this.A();
         }
      }
   }

   @Override
   public float h_() {
      return 0.0F;
   }

   public void b(double par1) {
      this.at = par1;
   }

   public double n() {
      return this.at;
   }

   public void b(int par1) {
      this.au = par1;
   }

   @Override
   public boolean k_() {
      return false;
   }
}
