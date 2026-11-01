import java.util.List;

public class EntityDragon extends ajn {
   public double a;
   public double b;
   public double c;
   public double[][] d = new double[64][3];
   public int e = -1;
   public dg[] NoiseGeneratorPerlin;
   public dg MapGenVillage;
   public dg GenLayerHills;
   public dg ap;
   public dg aq;
   public dg ar;
   public dg as;
   public dg at;
   public float au = 0.0F;
   public float EntityThrowable = 0.0F;
   public boolean aw = false;
   public boolean EntityAIAttackOnCollide = false;
   private Entity aB;
   public int StructureNetherBridgeStart = 0;
   public EntityEnderCrystal TileEntityDispenser = null;

   public EntityDragon(World par1World) {
      super(par1World);
      this.NoiseGeneratorPerlin = new dg[]{
         this.MapGenVillage = new dg(this, "head", 6.0F, 6.0F),
         this.GenLayerHills = new dg(this, "body", 8.0F, 8.0F),
         this.ap = new dg(this, "tail", 4.0F, 4.0F),
         this.aq = new dg(this, "tail", 4.0F, 4.0F),
         this.ar = new dg(this, "tail", 4.0F, 4.0F),
         this.as = new dg(this, "wing", 4.0F, 4.0F),
         this.at = new dg(this, "wing", 4.0F, 4.0F)
      };
      this.aA = 200;
      this.l(this.aA);
      this.bm = "/mob/enderdragon/ender.png";
      this.a(16.0F, 8.0F);
      this.S = true;
      this.ab = true;
      this.b = 100.0;
      this.ak = true;
   }

   protected void b() {
      super.b();
      this.EntityNoteFX.a(16, new Integer(this.aA));
   }

   public double[] a(int par1, float par2) {
      if (this.bx <= 0) {
         par2 = 0.0F;
      }

      par2 = 1.0F - par2;
      int i = this.e - par1 * 1 & 63;
      int j = this.e - par1 * 1 - 1 & 63;
      double[] ad = new double[3];
      double d = this.d[i][0];
      double d1 = this.d[j][0] - d;

      while (d1 < -180.0) {
         d1 += 360.0;
      }

      while (d1 >= 180.0) {
         d1 -= 360.0;
      }

      ad[0] = d + d1 * par2;
      d = this.d[i][1];
      d1 = this.d[j][1] - d;
      ad[1] = d + d1 * par2;
      ad[2] = this.d[i][2] + (this.d[j][2] - this.d[i][2]) * par2;
      return ad;
   }

   public void e() {
      this.au = this.EntityThrowable;
      if (!this.k.F) {
         this.EntityNoteFX.b(16, this.bx);
      }

      if (this.bx <= 0) {
         float f = (this.U.nextFloat() - 0.5F) * 8.0F;
         float f2 = (this.U.nextFloat() - 0.5F) * 4.0F;
         float f4 = (this.U.nextFloat() - 0.5F) * 8.0F;
         this.k.a("largeexplode", this.o + f, this.p + 2.0 + f2, this.q + f4, 0.0, 0.0, 0.0);
      } else {
         this.TileEntityMobSpawnerRenderer();
         float f1 = 0.2F / (MathHelper.a(this.r * this.r + this.t * this.t) * 10.0F + 1.0F);
         f1 *= (float)Math.pow(2.0, this.s);
         if (this.EntityAIAttackOnCollide) {
            this.EntityThrowable += f1 * 0.5F;
         } else {
            this.EntityThrowable += f1;
         }

         while (this.u >= 180.0F) {
            this.u -= 360.0F;
         }

         while (this.u < -180.0F) {
            this.u += 360.0F;
         }

         if (this.e < 0) {
            for (int i = 0; i < this.d.length; i++) {
               this.d[i][0] = this.u;
               this.d[i][1] = this.p;
            }
         }

         if (++this.e == this.d.length) {
            this.e = 0;
         }

         this.d[this.e][0] = this.u;
         this.d[this.e][1] = this.p;
         if (this.k.F) {
            if (this.bV > 0) {
               double d = this.o + (this.bW - this.o) / this.bV;
               double d2 = this.p + (this.bX - this.p) / this.bV;
               double d4 = this.q + (this.bY - this.q) / this.bV;
               double d6 = this.bZ - this.u;

               while (d6 < -180.0) {
                  d6 += 360.0;
               }

               while (d6 >= 180.0) {
                  d6 -= 360.0;
               }

               this.u = (float)(this.u + d6 / this.bV);
               this.v = (float)(this.v + (this.IChunkProvider - this.v) / this.bV);
               this.bV--;
               this.d(d, d2, d4);
               this.b(this.u, this.v);
            }
         } else {
            double d1 = this.a - this.o;
            double d3 = this.b - this.p;
            double d5 = this.c - this.q;
            double d7 = d1 * d1 + d3 * d3 + d5 * d5;
            if (this.aB != null) {
               this.a = this.aB.o;
               this.c = this.aB.q;
               double d8 = this.a - this.o;
               double d10 = this.c - this.q;
               double d12 = Math.sqrt(d8 * d8 + d10 * d10);
               double d13 = 0.4F + d12 / 80.0 - 1.0;
               if (d13 > 10.0) {
                  d13 = 10.0;
               }

               this.b = this.aB.y.b + d13;
            } else {
               this.a = this.a + this.U.nextGaussian() * 2.0;
               this.c = this.c + this.U.nextGaussian() * 2.0;
            }

            if (this.aw || d7 < 100.0 || d7 > 22500.0 || this.A || this.B) {
               this.ah();
            }

            d3 /= MathHelper.a(d1 * d1 + d5 * d5);
            float f10 = 0.6F;
            if (d3 < -f10) {
               d3 = -f10;
            }

            if (d3 > f10) {
               d3 = f10;
            }

            this.s += d3 * 0.1F;

            while (this.u < -180.0F) {
               this.u += 360.0F;
            }

            while (this.u >= 180.0F) {
               this.u -= 360.0F;
            }

            double d9 = 180.0 - Math.atan2(d1, d5) * 180.0 / Math.PI;
            double d11 = d9 - this.u;

            while (d11 < -180.0) {
               d11 += 360.0;
            }

            while (d11 >= 180.0) {
               d11 -= 360.0;
            }

            if (d11 > 50.0) {
               d11 = 50.0;
            }

            if (d11 < -50.0) {
               d11 = -50.0;
            }

            bo vec3d = bo.b(this.a - this.o, this.b - this.p, this.c - this.q).c();
            bo vec3d1 = bo.b(MathHelper.a(this.u * (float) Math.PI / 180.0F), this.s, -MathHelper.b(this.u * (float) Math.PI / 180.0F)).c();
            float f18 = (float)(vec3d1.b(vec3d) + 0.5) / 1.5F;
            if (f18 < 0.0F) {
               f18 = 0.0F;
            }

            this.cg *= 0.8F;
            float f19 = MathHelper.a(this.r * this.r + this.t * this.t) * 1.0F + 1.0F;
            double d14 = Math.sqrt(this.r * this.r + this.t * this.t) * 1.0 + 1.0;
            if (d14 > 40.0) {
               d14 = 40.0;
            }

            this.cg = (float)(this.cg + d11 * (0.7F / d14 / f19));
            this.u = this.u + this.cg * 0.1F;
            float f20 = (float)(2.0 / (d14 + 1.0));
            float f21 = 0.06F;
            this.a(0.0F, -1.0F, f21 * (f18 * f20 + (1.0F - f20)));
            if (this.EntityAIAttackOnCollide) {
               this.b(this.r * 0.8F, this.s * 0.8F, this.t * 0.8F);
            } else {
               this.b(this.r, this.s, this.t);
            }

            bo vec3d2 = bo.b(this.r, this.s, this.t).c();
            float f22 = (float)(vec3d2.b(vec3d1) + 1.0) / 2.0F;
            f22 = 0.8F + 0.15F * f22;
            this.r *= f22;
            this.t *= f22;
            this.s *= 0.91F;
         }

         this.bd = this.u;
         this.MapGenVillage.I = this.MapGenVillage.J = 3.0F;
         this.ap.I = this.ap.J = 2.0F;
         this.aq.I = this.aq.J = 2.0F;
         this.ar.I = this.ar.J = 2.0F;
         this.GenLayerHills.J = 3.0F;
         this.GenLayerHills.I = 5.0F;
         this.as.J = 2.0F;
         this.as.I = 4.0F;
         this.at.J = 3.0F;
         this.at.I = 4.0F;
         float f3 = (float)(this.a(5, 1.0F)[1] - this.a(10, 1.0F)[1]) * 10.0F / 180.0F * (float) Math.PI;
         float f5 = MathHelper.b(f3);
         float f6 = -MathHelper.a(f3);
         float f7 = this.u * (float) Math.PI / 180.0F;
         float f8 = MathHelper.a(f7);
         float f9 = MathHelper.b(f7);
         this.GenLayerHills.J_();
         this.GenLayerHills.c(this.o + f8 * 0.5F, this.p, this.q - f9 * 0.5F, 0.0F, 0.0F);
         this.as.J_();
         this.as.c(this.o + f9 * 4.5F, this.p + 2.0, this.q + f8 * 4.5F, 0.0F, 0.0F);
         this.at.J_();
         this.at.c(this.o - f9 * 4.5F, this.p + 2.0, this.q - f8 * 4.5F, 0.0F, 0.0F);
         if (!this.k.F) {
            this.ag();
         }

         if (!this.k.F && this.bB == 0) {
            this.a(this.k.b(this, this.as.y.b(4.0, 2.0, 4.0).d(0.0, -2.0, 0.0)));
            this.a(this.k.b(this, this.at.y.b(4.0, 2.0, 4.0).d(0.0, -2.0, 0.0)));
            this.b(this.k.b(this, this.MapGenVillage.y.b(1.0, 1.0, 1.0)));
         }

         double[] ad = this.a(5, 1.0F);
         double[] ad1 = this.a(0, 1.0F);
         float f11 = MathHelper.a(this.u * (float) Math.PI / 180.0F - this.cg * 0.01F);
         float f12 = MathHelper.b(this.u * (float) Math.PI / 180.0F - this.cg * 0.01F);
         this.MapGenVillage.J_();
         this.MapGenVillage.c(this.o + f11 * 5.5F * f5, this.p + (ad1[1] - ad[1]) * 1.0 + f6 * 5.5F, this.q - f12 * 5.5F * f5, 0.0F, 0.0F);

         for (int j = 0; j < 3; j++) {
            dg entitydragonpart = null;
            if (j == 0) {
               entitydragonpart = this.ap;
            }

            if (j == 1) {
               entitydragonpart = this.aq;
            }

            if (j == 2) {
               entitydragonpart = this.ar;
            }

            double[] ad2 = this.a(12 + j * 2, 1.0F);
            float f13 = this.u * (float) Math.PI / 180.0F + this.b(ad2[0] - ad[0]) * (float) Math.PI / 180.0F * 1.0F;
            float f14 = MathHelper.a(f13);
            float f15 = MathHelper.b(f13);
            float f16 = 1.5F;
            float f17 = (j + 1) * 2.0F;
            entitydragonpart.J_();
            entitydragonpart.c(
               this.o - (f8 * f16 + f14 * f17) * f5, this.p + (ad2[1] - ad[1]) * 1.0 - (f17 + f16) * f6 + 1.5, this.q + (f9 * f16 + f15 * f17) * f5, 0.0F, 0.0F
            );
         }

         if (!this.k.F) {
            this.EntityAIAttackOnCollide = this.a(this.MapGenVillage.y) | this.a(this.GenLayerHills.y);
         }
      }
   }

   private void TileEntityMobSpawnerRenderer() {
      if (this.TileEntityDispenser != null) {
         if (this.TileEntityDispenser.G) {
            if (!this.k.F) {
               this.a(this.MapGenVillage, md.l, 10);
            }

            this.TileEntityDispenser = null;
         } else if (this.V % 10 == 0 && this.bx < this.aA) {
            this.bx++;
         }
      }

      if (this.U.nextInt(10) == 0) {
         float f = 32.0F;
         List list = this.k.a(EntityEnderCrystal.class, this.y.b(f, f, f));
         EntityEnderCrystal entityendercrystal = null;
         double d = Double.MAX_VALUE;

         for (Entity entity : list) {
            double d1 = entity.f(this);
            if (d1 < d) {
               d = d1;
               entityendercrystal = (EntityEnderCrystal)entity;
            }
         }

         this.TileEntityDispenser = entityendercrystal;
      }
   }

   private void ag() {
   }

   private void a(List par1List) {
      double d = (this.GenLayerHills.y.a + this.GenLayerHills.y.d) / 2.0;
      double d1 = (this.GenLayerHills.y.c + this.GenLayerHills.y.f) / 2.0;

      for (Entity entity : par1List) {
         if (entity instanceof EntityLiving) {
            double d2 = entity.o - d;
            double d3 = entity.q - d1;
            double d4 = d2 * d2 + d3 * d3;
            entity.c(d2 / d4 * 4.0, 0.2F, d3 / d4 * 4.0);
         }
      }
   }

   private void b(List par1List) {
      for (int i = 0; i < par1List.size(); i++) {
         Entity entity = (Entity)par1List.get(i);
         if (entity instanceof EntityLiving) {
            entity.a(md.a(this), 10);
         }
      }
   }

   private void ah() {
      this.aw = false;
      if (this.U.nextInt(2) == 0 && this.k.d.size() > 0) {
         this.aB = (Entity)this.k.d.get(this.U.nextInt(this.k.d.size()));
      } else {
         boolean flag = false;

         do {
            this.a = 0.0;
            this.b = 70.0F + this.U.nextFloat() * 50.0F;
            this.c = 0.0;
            this.a = this.a + (this.U.nextFloat() * 120.0F - 60.0F);
            this.c = this.c + (this.U.nextFloat() * 120.0F - 60.0F);
            double d = this.o - this.a;
            double d1 = this.p - this.b;
            double d2 = this.q - this.c;
            flag = d * d + d1 * d1 + d2 * d2 > 100.0;
         } while (!flag);

         this.aB = null;
      }
   }

   private float b(double par1) {
      while (par1 >= 180.0) {
         par1 -= 360.0;
      }

      while (par1 < -180.0) {
         par1 += 360.0;
      }

      return (float)par1;
   }

   private boolean a(AxisAlignedBB par1AxisAlignedBB) {
      long i = MathHelper.d(par1AxisAlignedBB.a);
      int j = MathHelper.c(par1AxisAlignedBB.b);
      long k = MathHelper.d(par1AxisAlignedBB.c);
      long l = MathHelper.d(par1AxisAlignedBB.d);
      int i1 = MathHelper.c(par1AxisAlignedBB.e);
      long j1 = MathHelper.d(par1AxisAlignedBB.f);
      boolean flag = false;
      boolean flag1 = false;

      for (long k1 = i; k1 <= l; k1++) {
         for (int l1 = j; l1 <= i1; l1++) {
            for (long i2 = k; i2 <= j1; i2++) {
               int j2 = this.k.getBlockId(k1, l1, i2);
               if (j2 != 0) {
                  if (j2 != Block.ap.bO && j2 != Block.bJ.bO && j2 != Block.z.bO) {
                     flag1 = true;
                     this.k.setBlockWithNotify(k1, l1, i2, 0);
                  } else {
                     flag = true;
                  }
               }
            }
         }
      }

      if (flag1) {
         double d = par1AxisAlignedBB.a + (par1AxisAlignedBB.d - par1AxisAlignedBB.a) * this.U.nextFloat();
         double d1 = par1AxisAlignedBB.b + (par1AxisAlignedBB.e - par1AxisAlignedBB.b) * this.U.nextFloat();
         double d2 = par1AxisAlignedBB.c + (par1AxisAlignedBB.f - par1AxisAlignedBB.c) * this.U.nextFloat();
         this.k.a("largeexplode", d, d1, d2, 0.0, 0.0, 0.0);
      }

      return flag;
   }

   public boolean a(dg par1EntityDragonPart, md par2DamageSource, int par3) {
      if (par1EntityDragonPart != this.MapGenVillage) {
         par3 = par3 / 4 + 1;
      }

      float f = this.u * (float) Math.PI / 180.0F;
      float f1 = MathHelper.a(f);
      float f2 = MathHelper.b(f);
      this.a = this.o + f1 * 5.0F + (this.U.nextFloat() - 0.5F) * 2.0F;
      this.b = this.p + this.U.nextFloat() * 3.0F + 1.0;
      this.c = this.q - f2 * 5.0F + (this.U.nextFloat() - 0.5F) * 2.0F;
      this.aB = null;
      if (par2DamageSource.a() instanceof EntityPlayer || par2DamageSource == md.l) {
         this.e(par2DamageSource, par3);
      }

      return true;
   }

   protected void w_() {
      this.StructureNetherBridgeStart++;
      if (this.StructureNetherBridgeStart >= 180 && this.StructureNetherBridgeStart <= 200) {
         float f = (this.U.nextFloat() - 0.5F) * 8.0F;
         float f1 = (this.U.nextFloat() - 0.5F) * 4.0F;
         float f2 = (this.U.nextFloat() - 0.5F) * 8.0F;
         this.k.a("hugeexplosion", this.o + f, this.p + 2.0 + f1, this.q + f2, 0.0, 0.0, 0.0);
      }

      if (!this.k.F && this.StructureNetherBridgeStart > 150 && this.StructureNetherBridgeStart % 5 == 0) {
         int i = 1000;

         while (i > 0) {
            int k = EntityXPOrb.b(i);
            i -= k;
            this.k.a(new EntityXPOrb(this.k, this.o, this.p, this.q, k));
         }
      }

      this.b(0.0, 0.1F, 0.0);
      this.bd = this.u += 20.0F;
      if (this.StructureNetherBridgeStart == 200) {
         int j = 10000;

         while (j > 0) {
            int l = EntityXPOrb.b(j);
            j -= l;
            this.k.a(new EntityXPOrb(this.k, this.o, this.p, this.q, l));
         }

         this.createEnderPortal(MathHelper.d(this.o), MathHelper.d(this.q));
         this.EntityAnimal();
         this.A();
      }
   }

   private void createEnderPortal(long par1, long par2) {
      byte byte0 = 64;
      BlockEndPortal.a = true;
      int i = 4;

      for (int j = byte0 - 1; j <= byte0 + 32; j++) {
         for (long k = par1 - i; k <= par1 + i; k++) {
            for (long l = par2 - i; l <= par2 + i; l++) {
               double d = k - par1;
               double d1 = l - par2;
               double d2 = MathHelper.a(d * d + d1 * d1);
               if (!(d2 > i - 0.5)) {
                  if (j < byte0) {
                     if (d2 <= i - 1 - 0.5) {
                        this.k.setBlockWithNotify(k, j, l, Block.z.bO);
                     }
                  } else if (j > byte0) {
                     this.k.setBlockWithNotify(k, j, l, 0);
                  } else if (d2 > i - 1 - 0.5) {
                     this.k.setBlockWithNotify(k, j, l, Block.z.bO);
                  } else {
                     this.k.setBlockWithNotify(k, j, l, Block.bH.bO);
                  }
               }
            }
         }
      }

      this.k.setBlockWithNotify(par1, byte0 + 0, par2, Block.z.bO);
      this.k.setBlockWithNotify(par1, byte0 + 1, par2, Block.z.bO);
      this.k.setBlockWithNotify(par1, byte0 + 2, par2, Block.z.bO);
      this.k.setBlockWithNotify(par1 - 1L, byte0 + 2, par2, Block.aq.bO);
      this.k.setBlockWithNotify(par1 + 1L, byte0 + 2, par2, Block.aq.bO);
      this.k.setBlockWithNotify(par1, byte0 + 2, par2 - 1L, Block.aq.bO);
      this.k.setBlockWithNotify(par1, byte0 + 2, par2 + 1L, Block.aq.bO);
      this.k.setBlockWithNotify(par1, byte0 + 3, par2, Block.z.bO);
      this.k.setBlockWithNotify(par1, byte0 + 4, par2, Block.bK.bO);
      BlockEndPortal.a = false;
   }

   protected void w() {
   }

   public Entity[] Z() {
      return this.NoiseGeneratorPerlin;
   }

   public boolean l_() {
      return false;
   }

   public int x() {
      return this.EntityNoteFX.c(16);
   }
}
