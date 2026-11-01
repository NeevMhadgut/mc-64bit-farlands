import java.util.List;

public class EntityFishHook extends Entity {
   private long d = -1L;
   private int e = -1;
   private long NoiseGeneratorPerlin = -1L;
   private int MapGenVillage = 0;
   private boolean GenLayerHills = false;
   public int a = 0;
   public EntityPlayer b;
   private int ap;
   private int aq = 0;
   private int ar = 0;
   public Entity c = null;
   private int as;
   private double at;
   private double au;
   private double EntityThrowable;
   private double aw;
   private double EntityAIAttackOnCollide;
   private double StructureNetherBridgeStart;
   private double TileEntityDispenser;
   private double aA;

   public EntityFishHook(World par1World) {
      super(par1World);
      this.a(0.25F, 0.25F);
      this.ak = true;
   }

   public EntityFishHook(World par1World, double par2, double par4, double par6) {
      this(par1World);
      this.d(par2, par4, par6);
      this.ak = true;
   }

   public EntityFishHook(World par1World, EntityPlayer par2EntityPlayer) {
      super(par1World);
      this.ak = true;
      this.b = par2EntityPlayer;
      this.b.aZ = this;
      this.a(0.25F, 0.25F);
      this.c(par2EntityPlayer.o, par2EntityPlayer.p + 1.62 - par2EntityPlayer.H, par2EntityPlayer.q, par2EntityPlayer.u, par2EntityPlayer.v);
      this.o = this.o - MathHelper.b(this.u / 180.0F * (float) Math.PI) * 0.16F;
      this.p -= 0.1F;
      this.q = this.q - MathHelper.a(this.u / 180.0F * (float) Math.PI) * 0.16F;
      this.d(this.o, this.p, this.q);
      this.H = 0.0F;
      float f = 0.4F;
      this.r = -MathHelper.a(this.u / 180.0F * (float) Math.PI) * MathHelper.b(this.v / 180.0F * (float) Math.PI) * f;
      this.t = MathHelper.b(this.u / 180.0F * (float) Math.PI) * MathHelper.b(this.v / 180.0F * (float) Math.PI) * f;
      this.s = -MathHelper.a(this.v / 180.0F * (float) Math.PI) * f;
      this.a(this.r, this.s, this.t, 1.5F, 1.0F);
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
      this.ap = 0;
   }

   @Override
   public void a(double par1, double par3, double par5, float par7, float par8, int par9) {
      this.at = par1;
      this.au = par3;
      this.EntityThrowable = par5;
      this.aw = par7;
      this.EntityAIAttackOnCollide = par8;
      this.as = par9;
      this.r = this.StructureNetherBridgeStart;
      this.s = this.TileEntityDispenser;
      this.t = this.aA;
   }

   @Override
   public void a(double par1, double par3, double par5) {
      this.StructureNetherBridgeStart = this.r = par1;
      this.TileEntityDispenser = this.s = par3;
      this.aA = this.t = par5;
   }

   @Override
   public void J_() {
      super.J_();
      if (this.as > 0) {
         double d = this.o + (this.at - this.o) / this.as;
         double d1 = this.p + (this.au - this.p) / this.as;
         double d2 = this.q + (this.EntityThrowable - this.q) / this.as;
         double d4 = this.aw - this.u;

         while (d4 < -180.0) {
            d4 += 360.0;
         }

         while (d4 >= 180.0) {
            d4 -= 360.0;
         }

         this.u = (float)(this.u + d4 / this.as);
         this.v = (float)(this.v + (this.EntityAIAttackOnCollide - this.v) / this.as);
         this.as--;
         this.d(d, d1, d2);
         this.b(this.u, this.v);
      } else {
         if (!this.k.F) {
            ItemStack itemstack = this.b.EntityThrowable();
            if (this.b.G || !this.b.M() || itemstack == null || itemstack.a() != Item.aR || this.f(this.b) > 1024.0) {
               this.A();
               this.b.aZ = null;
               return;
            }

            if (this.c != null) {
               if (!this.c.G) {
                  this.o = this.c.o;
                  this.p = this.c.y.b + this.c.J * 0.8;
                  this.q = this.c.q;
                  return;
               }

               this.c = null;
            }
         }

         if (this.a > 0) {
            this.a--;
         }

         if (this.GenLayerHills) {
            int i = this.k.getBlockId(this.d, this.e, this.NoiseGeneratorPerlin);
            if (i == this.MapGenVillage) {
               this.ap++;
               if (this.ap == 1200) {
                  this.A();
               }

               return;
            }

            this.GenLayerHills = false;
            this.r = this.r * (this.U.nextFloat() * 0.2F);
            this.s = this.s * (this.U.nextFloat() * 0.2F);
            this.t = this.t * (this.U.nextFloat() * 0.2F);
            this.ap = 0;
            this.aq = 0;
         } else {
            this.aq++;
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
         double d3 = 0.0;

         for (int j = 0; j < list.size(); j++) {
            Entity entity1 = (Entity)list.get(j);
            if (entity1.l_() && (entity1 != this.b || this.aq >= 5)) {
               float f2 = 0.3F;
               AxisAlignedBB axisalignedbb = entity1.y.b(f2, f2, f2);
               MovingObjectPosition movingobjectposition1 = axisalignedbb.a(vec3d, vec3d1);
               if (movingobjectposition1 != null) {
                  double d6 = vec3d.d(movingobjectposition1.f);
                  if (d6 < d3 || d3 == 0.0) {
                     entity = entity1;
                     d3 = d6;
                  }
               }
            }
         }

         if (entity != null) {
            movingobjectposition = new MovingObjectPosition(entity);
         }

         if (movingobjectposition != null) {
            if (movingobjectposition.g != null) {
               if (movingobjectposition.g.a(md.a(this, this.b), 0)) {
                  this.c = movingobjectposition.g;
               }
            } else {
               this.GenLayerHills = true;
            }
         }

         if (!this.GenLayerHills) {
            this.b(this.r, this.s, this.t);
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
            float f1 = 0.92F;
            if (this.z || this.A) {
               f1 = 0.5F;
            }

            int k = 5;
            double d5 = 0.0;

            for (int l = 0; l < k; l++) {
               double d8 = this.y.b + (this.y.e - this.y.b) * (l + 0) / k - 0.125 + 0.125;
               double d9 = this.y.b + (this.y.e - this.y.b) * (l + 1) / k - 0.125 + 0.125;
               AxisAlignedBB axisalignedbb1 = AxisAlignedBB.b(this.y.a, d8, this.y.c, this.y.d, d9, this.y.f);
               if (this.k.b(axisalignedbb1, acn.g)) {
                  d5 += 1.0 / k;
               }
            }

            if (d5 > 0.0) {
               if (this.ar > 0) {
                  this.ar--;
               } else {
                  char c = 500;
                  if (this.k.canLightningStrikeAt(MathHelper.d(this.o), MathHelper.c(this.p) + 1, MathHelper.d(this.q))) {
                     c = 300;
                  }

                  if (this.U.nextInt(c) == 0) {
                     this.ar = this.U.nextInt(30) + 10;
                     this.s -= 0.2F;
                     this.k.a(this, "random.splash", 0.25F, 1.0F + (this.U.nextFloat() - this.U.nextFloat()) * 0.4F);
                     float f3 = MathHelper.c(this.y.b);

                     for (int i1 = 0; i1 < 1.0F + this.I * 20.0F; i1++) {
                        float f4 = (this.U.nextFloat() * 2.0F - 1.0F) * this.I;
                        float f6 = (this.U.nextFloat() * 2.0F - 1.0F) * this.I;
                        this.k.a("bubble", this.o + f4, f3 + 1.0F, this.q + f6, this.r, this.s - this.U.nextFloat() * 0.2F, this.t);
                     }

                     for (int j1 = 0; j1 < 1.0F + this.I * 20.0F; j1++) {
                        float f5 = (this.U.nextFloat() * 2.0F - 1.0F) * this.I;
                        float f7 = (this.U.nextFloat() * 2.0F - 1.0F) * this.I;
                        this.k.a("splash", this.o + f5, f3 + 1.0F, this.q + f7, this.r, this.s, this.t);
                     }
                  }
               }
            }

            if (this.ar > 0) {
               this.s = this.s - this.U.nextFloat() * this.U.nextFloat() * this.U.nextFloat() * 0.2;
            }

            double d7 = d5 * 2.0 - 1.0;
            this.s += 0.04F * d7;
            if (d5 > 0.0) {
               f1 = (float)(f1 * 0.9);
               this.s *= 0.8;
            }

            this.r *= f1;
            this.s *= f1;
            this.t *= f1;
            this.d(this.o, this.p, this.q);
         }
      }
   }

   @Override
   public void b(ady par1NBTTagCompound) {
      par1NBTTagCompound.a("xTile", (short)this.d);
      par1NBTTagCompound.a("yTile", (short)this.e);
      par1NBTTagCompound.a("zTile", (short)this.NoiseGeneratorPerlin);
      par1NBTTagCompound.a("inTile", (byte)this.MapGenVillage);
      par1NBTTagCompound.a("shake", (byte)this.a);
      par1NBTTagCompound.a("inGround", (byte)(this.GenLayerHills ? 1 : 0));
   }

   @Override
   public void a(ady par1NBTTagCompound) {
      this.d = par1NBTTagCompound.e("xTile");
      this.e = par1NBTTagCompound.e("yTile");
      this.NoiseGeneratorPerlin = par1NBTTagCompound.e("zTile");
      this.MapGenVillage = par1NBTTagCompound.d("inTile") & 255;
      this.a = par1NBTTagCompound.d("shake") & 255;
      this.GenLayerHills = par1NBTTagCompound.d("inGround") == 1;
   }

   @Override
   public float h_() {
      return 0.0F;
   }

   public int n() {
      byte byte0 = 0;
      if (this.c != null) {
         double d = this.b.o - this.o;
         double d2 = this.b.p - this.p;
         double d4 = this.b.q - this.q;
         double d6 = MathHelper.a(d * d + d2 * d2 + d4 * d4);
         double d8 = 0.1;
         this.c.r += d * d8;
         this.c.s = this.c.s + (d2 * d8 + MathHelper.a(d6) * 0.08);
         this.c.t += d4 * d8;
         byte0 = 3;
      } else if (this.ar > 0) {
         EntityItem entityitem = new EntityItem(this.k, this.o, this.p, this.q, new ItemStack(Item.aU));
         double d1 = this.b.o - this.o;
         double d3 = this.b.p - this.p;
         double d5 = this.b.q - this.q;
         double d7 = MathHelper.a(d1 * d1 + d3 * d3 + d5 * d5);
         double d9 = 0.1;
         entityitem.r = d1 * d9;
         entityitem.s = d3 * d9 + MathHelper.a(d7) * 0.08;
         entityitem.t = d5 * d9;
         this.k.a(entityitem);
         this.b.a(gv.B, 1);
         byte0 = 1;
      }

      if (this.GenLayerHills) {
         byte0 = 2;
      }

      this.A();
      this.b.aZ = null;
      return byte0;
   }
}
