import java.util.List;

public class EntityMinecart extends Entity implements io {
   private ItemStack[] d = new ItemStack[36];
   private int e = 0;
   private boolean NoiseGeneratorPerlin = false;
   public int a;
   public double b;
   public double c;
   private static final int[][][] MapGenVillage = new int[][][]{
      {{0, 0, -1}, {0, 0, 1}},
      {{-1, 0, 0}, {1, 0, 0}},
      {{-1, -1, 0}, {1, 0, 0}},
      {{-1, 0, 0}, {1, -1, 0}},
      {{0, 0, -1}, {0, -1, 1}},
      {{0, -1, -1}, {0, 0, 1}},
      {{0, 0, 1}, {1, 0, 0}},
      {{0, 0, 1}, {-1, 0, 0}},
      {{0, 0, -1}, {-1, 0, 0}},
      {{0, 0, -1}, {1, 0, 0}}
   };
   private int GenLayerHills;
   private double ap;
   private double aq;
   private double ar;
   private double as;
   private double at;
   private double au;
   private double EntityThrowable;
   private double aw;

   public EntityMinecart(World par1World) {
      super(par1World);
      this.h = true;
      this.a(0.98F, 0.7F);
      this.H = this.J / 2.0F;
   }

   @Override
   protected boolean e_() {
      return false;
   }

   @Override
   protected void b() {
      this.EntityNoteFX.a(16, new Byte((byte)0));
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
      return null;
   }

   @Override
   public boolean d_() {
      return true;
   }

   public EntityMinecart(World par1World, double par2, double par4, double par6, int par8) {
      this(par1World);
      this.d(par2, par4 + this.H, par6);
      this.r = 0.0;
      this.s = 0.0;
      this.t = 0.0;
      this.l = par2;
      this.m = par4;
      this.n = par6;
      this.a = par8;
   }

   @Override
   public double l() {
      return this.J * 0.0 - 0.3F;
   }

   @Override
   public boolean a(md par1DamageSource, int par2) {
      if (!this.k.F && !this.G) {
         this.h(-this.r());
         this.d(10);
         this.K();
         this.c(this.o() + par2 * 10);
         if (this.o() > 40) {
            if (this.i != null) {
               this.i.h(this);
            }

            this.A();
            this.a(Item.TileEntityDispenser.bQ, 1, 0.0F);
            if (this.a == 1) {
               EntityMinecart entityminecart = this;

               for (int i = 0; i < entityminecart.a(); i++) {
                  ItemStack itemstack = entityminecart.k_(i);
                  if (itemstack != null) {
                     float f = this.U.nextFloat() * 0.8F + 0.1F;
                     float f1 = this.U.nextFloat() * 0.8F + 0.1F;
                     float f2 = this.U.nextFloat() * 0.8F + 0.1F;

                     while (itemstack.a > 0) {
                        int j = this.U.nextInt(21) + 10;
                        if (j > itemstack.a) {
                           j = itemstack.a;
                        }

                        itemstack.a -= j;
                        EntityItem entityitem = new EntityItem(this.k, this.o + f, this.p + f1, this.q + f2, new ItemStack(itemstack.c, j, itemstack.i()));
                        float f3 = 0.05F;
                        entityitem.r = (float)this.U.nextGaussian() * f3;
                        entityitem.s = (float)this.U.nextGaussian() * f3 + 0.2F;
                        entityitem.t = (float)this.U.nextGaussian() * f3;
                        this.k.a(entityitem);
                     }
                  }
               }

               this.a(Block.au.bO, 1, 0.0F);
            } else if (this.a == 2) {
               this.a(Block.aB.bO, 1, 0.0F);
            }
         }

         return true;
      } else {
         return true;
      }
   }

   @Override
   public void k() {
      this.h(-this.r());
      this.d(10);
      this.c(this.o() + this.o() * 10);
   }

   @Override
   public boolean l_() {
      return !this.G;
   }

   @Override
   public void A() {
      for (int i = 0; i < this.a(); i++) {
         ItemStack itemstack = this.k_(i);
         if (itemstack != null) {
            float f = this.U.nextFloat() * 0.8F + 0.1F;
            float f1 = this.U.nextFloat() * 0.8F + 0.1F;
            float f2 = this.U.nextFloat() * 0.8F + 0.1F;

            while (itemstack.a > 0) {
               int j = this.U.nextInt(21) + 10;
               if (j > itemstack.a) {
                  j = itemstack.a;
               }

               itemstack.a -= j;
               EntityItem entityitem = new EntityItem(this.k, this.o + f, this.p + f1, this.q + f2, new ItemStack(itemstack.c, j, itemstack.i()));
               if (itemstack.n()) {
                  entityitem.a.d((ady)itemstack.o().b());
               }

               float f3 = 0.05F;
               entityitem.r = (float)this.U.nextGaussian() * f3;
               entityitem.s = (float)this.U.nextGaussian() * f3 + 0.2F;
               entityitem.t = (float)this.U.nextGaussian() * f3;
               this.k.a(entityitem);
            }
         }
      }

      super.A();
   }

   @Override
   public void J_() {
      if (this.p() > 0) {
         this.d(this.p() - 1);
      }

      if (this.o() > 0) {
         this.c(this.o() - 1);
      }

      if (this.p < -64.0) {
         this.E();
      }

      if (this.n() && this.U.nextInt(4) == 0) {
         this.k.a("largesmoke", this.o, this.p + 0.8, this.q, 0.0, 0.0, 0.0);
      }

      if (this.k.F) {
         if (this.GenLayerHills > 0) {
            double d = this.o + (this.ap - this.o) / this.GenLayerHills;
            double d1 = this.p + (this.aq - this.p) / this.GenLayerHills;
            double d3 = this.q + (this.ar - this.q) / this.GenLayerHills;
            double d5 = this.as - this.u;

            while (d5 < -180.0) {
               d5 += 360.0;
            }

            while (d5 >= 180.0) {
               d5 -= 360.0;
            }

            this.u = (float)(this.u + d5 / this.GenLayerHills);
            this.v = (float)(this.v + (this.at - this.v) / this.GenLayerHills);
            this.GenLayerHills--;
            this.d(d, d1, d3);
            this.b(this.u, this.v);
         } else {
            this.d(this.o, this.p, this.q);
            this.b(this.u, this.v);
         }
      } else {
         this.l = this.o;
         this.m = this.p;
         this.n = this.q;
         this.s -= 0.04F;
         long i = MathHelper.d(this.o);
         int j = MathHelper.c(this.p);
         long k = MathHelper.d(this.q);
         if (BlockRail.isRailBlockAt(this.k, i, j - 1, k)) {
            j--;
         }

         double d2 = 0.4;
         double d4 = 0.0078125;
         int l = this.k.getBlockId(i, j, k);
         if (BlockRail.e(l)) {
            bo vec3d = this.i(this.o, this.p, this.q);
            int i1 = this.k.getBlockMetadata(i, j, k);
            this.p = j;
            boolean flag = false;
            boolean flag1 = false;
            if (l == Block.T.bO) {
               flag = (i1 & 8) != 0;
               flag1 = !flag;
            }

            if (((BlockRail)Block.m[l]).v()) {
               i1 &= 7;
            }

            if (i1 >= 2 && i1 <= 5) {
               this.p = j + 1;
            }

            if (i1 == 2) {
               this.r -= d4;
            }

            if (i1 == 3) {
               this.r += d4;
            }

            if (i1 == 4) {
               this.t += d4;
            }

            if (i1 == 5) {
               this.t -= d4;
            }

            int[][] ai = MapGenVillage[i1];
            double d9 = ai[1][0] - ai[0][0];
            double d10 = ai[1][2] - ai[0][2];
            double d11 = Math.sqrt(d9 * d9 + d10 * d10);
            double d12 = this.r * d9 + this.t * d10;
            if (d12 < 0.0) {
               d9 = -d9;
               d10 = -d10;
            }

            double d13 = Math.sqrt(this.r * this.r + this.t * this.t);
            this.r = d13 * d9 / d11;
            this.t = d13 * d10 / d11;
            if (flag1) {
               double d16 = Math.sqrt(this.r * this.r + this.t * this.t);
               if (d16 < 0.03) {
                  this.r *= 0.0;
                  this.s *= 0.0;
                  this.t *= 0.0;
               } else {
                  this.r *= 0.5;
                  this.s *= 0.0;
                  this.t *= 0.5;
               }
            }

            double d17 = 0.0;
            double d18 = i + 0.5 + ai[0][0] * 0.5;
            double d19 = k + 0.5 + ai[0][2] * 0.5;
            double d20 = i + 0.5 + ai[1][0] * 0.5;
            double d21 = k + 0.5 + ai[1][2] * 0.5;
            d9 = d20 - d18;
            d10 = d21 - d19;
            if (d9 == 0.0) {
               this.o = i + 0.5;
               d17 = this.q - k;
            } else if (d10 == 0.0) {
               this.q = k + 0.5;
               d17 = this.o - i;
            } else {
               double d22 = this.o - d18;
               double d24 = this.q - d19;
               double d26 = (d22 * d9 + d24 * d10) * 2.0;
               d17 = d26;
            }

            this.o = d18 + d9 * d17;
            this.q = d19 + d10 * d17;
            this.d(this.o, this.p + this.H, this.q);
            double d23 = this.r;
            double d25 = this.t;
            if (this.i != null) {
               d23 *= 0.75;
               d25 *= 0.75;
            }

            if (d23 < -d2) {
               d23 = -d2;
            }

            if (d23 > d2) {
               d23 = d2;
            }

            if (d25 < -d2) {
               d25 = -d2;
            }

            if (d25 > d2) {
               d25 = d2;
            }

            this.b(d23, 0.0, d25);
            if (ai[0][1] != 0 && MathHelper.d(this.o) - i == ai[0][0] && MathHelper.d(this.q) - k == ai[0][2]) {
               this.d(this.o, this.p + ai[0][1], this.q);
            } else if (ai[1][1] != 0 && MathHelper.d(this.o) - i == ai[1][0] && MathHelper.d(this.q) - k == ai[1][2]) {
               this.d(this.o, this.p + ai[1][1], this.q);
            }

            if (this.i != null) {
               this.r *= 0.997F;
               this.s *= 0.0;
               this.t *= 0.997F;
            } else {
               if (this.a == 2) {
                  double d27 = MathHelper.a(this.b * this.b + this.c * this.c);
                  if (d27 > 0.01) {
                     this.b /= d27;
                     this.c /= d27;
                     double d29 = 0.04;
                     this.r *= 0.8F;
                     this.s *= 0.0;
                     this.t *= 0.8F;
                     this.r = this.r + this.b * d29;
                     this.t = this.t + this.c * d29;
                  } else {
                     this.r *= 0.9F;
                     this.s *= 0.0;
                     this.t *= 0.9F;
                  }
               }

               this.r *= 0.96F;
               this.s *= 0.0;
               this.t *= 0.96F;
            }

            bo vec3d1 = this.i(this.o, this.p, this.q);
            if (vec3d1 != null && vec3d != null) {
               double d28 = (vec3d.b - vec3d1.b) * 0.05;
               double d14 = Math.sqrt(this.r * this.r + this.t * this.t);
               if (d14 > 0.0) {
                  this.r = this.r / d14 * (d14 + d28);
                  this.t = this.t / d14 * (d14 + d28);
               }

               this.d(this.o, vec3d1.b, this.q);
            }

            long k1 = MathHelper.d(this.o);
            long l1 = MathHelper.d(this.q);
            if (k1 != i || l1 != k) {
               double d15 = Math.sqrt(this.r * this.r + this.t * this.t);
               this.r = d15 * (k1 - i);
               this.t = d15 * (l1 - k);
            }

            if (this.a == 2) {
               double d30 = MathHelper.a(this.b * this.b + this.c * this.c);
               if (d30 > 0.01 && this.r * this.r + this.t * this.t > 0.001) {
                  this.b /= d30;
                  this.c /= d30;
                  if (this.b * this.r + this.c * this.t < 0.0) {
                     this.b = 0.0;
                     this.c = 0.0;
                  } else {
                     this.b = this.r;
                     this.c = this.t;
                  }
               }
            }

            if (flag) {
               double d31 = Math.sqrt(this.r * this.r + this.t * this.t);
               if (d31 > 0.01) {
                  double d32 = 0.06;
                  this.r = this.r + this.r / d31 * d32;
                  this.t = this.t + this.t / d31 * d32;
               } else if (i1 == 1) {
                  if (this.k.isBlockNormalCube(i - 1L, j, k)) {
                     this.r = 0.02;
                  } else if (this.k.isBlockNormalCube(i + 1L, j, k)) {
                     this.r = -0.02;
                  }
               } else if (i1 == 0) {
                  if (this.k.isBlockNormalCube(i, j, k - 1L)) {
                     this.t = 0.02;
                  } else if (this.k.isBlockNormalCube(i, j, k + 1L)) {
                     this.t = -0.02;
                  }
               }
            }
         } else {
            if (this.r < -d2) {
               this.r = -d2;
            }

            if (this.r > d2) {
               this.r = d2;
            }

            if (this.t < -d2) {
               this.t = -d2;
            }

            if (this.t > d2) {
               this.t = d2;
            }

            if (this.z) {
               this.r *= 0.5;
               this.s *= 0.5;
               this.t *= 0.5;
            }

            this.b(this.r, this.s, this.t);
            if (!this.z) {
               this.r *= 0.95F;
               this.s *= 0.95F;
               this.t *= 0.95F;
            }
         }

         this.v = 0.0F;
         double d6 = this.l - this.o;
         double d7 = this.n - this.q;
         if (d6 * d6 + d7 * d7 > 0.001) {
            this.u = (float)(Math.atan2(d7, d6) * 180.0 / Math.PI);
            if (this.NoiseGeneratorPerlin) {
               this.u += 180.0F;
            }
         }

         double d8 = this.u - this.w;

         while (d8 >= 180.0) {
            d8 -= 360.0;
         }

         while (d8 < -180.0) {
            d8 += 360.0;
         }

         if (d8 < -170.0 || d8 >= 170.0) {
            this.u += 180.0F;
            this.NoiseGeneratorPerlin = !this.NoiseGeneratorPerlin;
         }

         this.b(this.u, this.v);
         List list = this.k.b(this, this.y.b(0.2F, 0.0, 0.2F));
         if (list != null && list.size() > 0) {
            for (int j1 = 0; j1 < list.size(); j1++) {
               Entity entity = (Entity)list.get(j1);
               if (entity != this.i && entity.d_() && entity instanceof EntityMinecart) {
                  entity.g(this);
               }
            }
         }

         if (this.i != null && this.i.G) {
            if (this.i.j == this) {
               this.i.j = null;
            }

            this.i = null;
         }

         if (this.e > 0) {
            this.e--;
         }

         if (this.e <= 0) {
            this.b = this.c = 0.0;
         }

         this.a(this.e > 0);
      }
   }

   public bo a(double par1, double par3, double par5, double par7) {
      long i = MathHelper.d(par1);
      int j = MathHelper.c(par3);
      long k = MathHelper.d(par5);
      if (BlockRail.isRailBlockAt(this.k, i, j - 1, k)) {
         j--;
      }

      int l = this.k.getBlockId(i, j, k);
      if (!BlockRail.e(l)) {
         return null;
      }

      int i1 = this.k.getBlockMetadata(i, j, k);
      if (((BlockRail)Block.m[l]).v()) {
         i1 &= 7;
      }

      par3 = j;
      if (i1 >= 2 && i1 <= 5) {
         par3 = j + 1;
      }

      int[][] ai = MapGenVillage[i1];
      double d = ai[1][0] - ai[0][0];
      double d1 = ai[1][2] - ai[0][2];
      double d2 = Math.sqrt(d * d + d1 * d1);
      d /= d2;
      d1 /= d2;
      par1 += d * par7;
      par5 += d1 * par7;
      if (ai[0][1] != 0 && MathHelper.d(par1) - i == ai[0][0] && MathHelper.d(par5) - k == ai[0][2]) {
         par3 += ai[0][1];
      } else if (ai[1][1] != 0 && MathHelper.d(par1) - i == ai[1][0] && MathHelper.d(par5) - k == ai[1][2]) {
         par3 += ai[1][1];
      }

      return this.i(par1, par3, par5);
   }

   public bo i(double par1, double par3, double par5) {
      long i = MathHelper.d(par1);
      int j = MathHelper.c(par3);
      long k = MathHelper.d(par5);
      if (BlockRail.isRailBlockAt(this.k, i, j - 1, k)) {
         j--;
      }

      int l = this.k.getBlockId(i, j, k);
      if (BlockRail.e(l)) {
         int i1 = this.k.getBlockMetadata(i, j, k);
         par3 = j;
         if (((BlockRail)Block.m[l]).v()) {
            i1 &= 7;
         }

         if (i1 >= 2 && i1 <= 5) {
            par3 = j + 1;
         }

         int[][] ai = MapGenVillage[i1];
         double d = 0.0;
         double d1 = i + 0.5 + ai[0][0] * 0.5;
         double d2 = j + 0.5 + ai[0][1] * 0.5;
         double d3 = k + 0.5 + ai[0][2] * 0.5;
         double d4 = i + 0.5 + ai[1][0] * 0.5;
         double d5 = j + 0.5 + ai[1][1] * 0.5;
         double d6 = k + 0.5 + ai[1][2] * 0.5;
         double d7 = d4 - d1;
         double d8 = (d5 - d2) * 2.0;
         double d9 = d6 - d3;
         if (d7 == 0.0) {
            par1 = i + 0.5;
            d = par5 - k;
         } else if (d9 == 0.0) {
            par5 = k + 0.5;
            d = par1 - i;
         } else {
            double d10 = par1 - d1;
            double d11 = par5 - d3;
            double d12 = (d10 * d7 + d11 * d9) * 2.0;
            d = d12;
         }

         par1 = d1 + d7 * d;
         par3 = d2 + d8 * d;
         par5 = d3 + d9 * d;
         if (d8 < 0.0) {
            par3++;
         }

         if (d8 > 0.0) {
            par3 += 0.5;
         }

         return bo.b(par1, par3, par5);
      } else {
         return null;
      }
   }

   @Override
   protected void b(ady par1NBTTagCompound) {
      par1NBTTagCompound.a("Type", this.a);
      if (this.a == 2) {
         par1NBTTagCompound.a("PushX", this.b);
         par1NBTTagCompound.a("PushZ", this.c);
         par1NBTTagCompound.a("Fuel", (short)this.e);
      } else if (this.a == 1) {
         no nbttaglist = new no();

         for (int i = 0; i < this.d.length; i++) {
            if (this.d[i] != null) {
               ady nbttagcompound = new ady();
               nbttagcompound.a("Slot", (byte)i);
               this.d[i].b(nbttagcompound);
               nbttaglist.a(nbttagcompound);
            }
         }

         par1NBTTagCompound.a("Items", nbttaglist);
      }
   }

   @Override
   protected void a(ady par1NBTTagCompound) {
      this.a = par1NBTTagCompound.f("Type");
      if (this.a == 2) {
         this.b = par1NBTTagCompound.i("PushX");
         this.c = par1NBTTagCompound.i("PushZ");
         this.e = par1NBTTagCompound.e("Fuel");
      } else if (this.a == 1) {
         no nbttaglist = par1NBTTagCompound.n("Items");
         this.d = new ItemStack[this.a()];

         for (int i = 0; i < nbttaglist.d(); i++) {
            ady nbttagcompound = (ady)nbttaglist.a(i);
            int j = nbttagcompound.d("Slot") & 255;
            if (j >= 0 && j < this.d.length) {
               this.d[j] = ItemStack.a(nbttagcompound);
            }
         }
      }
   }

   @Override
   public float h_() {
      return 0.0F;
   }

   @Override
   public void g(Entity par1Entity) {
      if (!this.k.F) {
         if (par1Entity != this.i) {
            if (par1Entity instanceof EntityLiving
               && !(par1Entity instanceof EntityPlayer)
               && !(par1Entity instanceof EntityIronGolem)
               && this.a == 0
               && this.r * this.r + this.t * this.t > 0.01
               && this.i == null
               && par1Entity.j == null) {
               par1Entity.h(this);
            }

            double d = par1Entity.o - this.o;
            double d1 = par1Entity.q - this.q;
            double d2 = d * d + d1 * d1;
            if (d2 >= 1.0E-4F) {
               d2 = MathHelper.a(d2);
               d /= d2;
               d1 /= d2;
               double d3 = 1.0 / d2;
               if (d3 > 1.0) {
                  d3 = 1.0;
               }

               d *= d3;
               d1 *= d3;
               d *= 0.1F;
               d1 *= 0.1F;
               d *= 1.0F - this.T;
               d1 *= 1.0F - this.T;
               d *= 0.5;
               d1 *= 0.5;
               if (par1Entity instanceof EntityMinecart) {
                  double d4 = par1Entity.o - this.o;
                  double d5 = par1Entity.q - this.q;
                  bo vec3d = bo.b(d4, 0.0, d5).c();
                  bo vec3d1 = bo.b(MathHelper.b(this.u * (float) Math.PI / 180.0F), 0.0, MathHelper.a(this.u * (float) Math.PI / 180.0F)).c();
                  double d6 = Math.abs(vec3d.b(vec3d1));
                  if (d6 < 0.8F) {
                     return;
                  }

                  double d7 = par1Entity.r + this.r;
                  double d8 = par1Entity.t + this.t;
                  if (((EntityMinecart)par1Entity).a == 2 && this.a != 2) {
                     this.r *= 0.2F;
                     this.t *= 0.2F;
                     this.c(par1Entity.r - d, 0.0, par1Entity.t - d1);
                     par1Entity.r *= 0.95F;
                     par1Entity.t *= 0.95F;
                  } else if (((EntityMinecart)par1Entity).a != 2 && this.a == 2) {
                     par1Entity.r *= 0.2F;
                     par1Entity.t *= 0.2F;
                     par1Entity.c(this.r + d, 0.0, this.t + d1);
                     this.r *= 0.95F;
                     this.t *= 0.95F;
                  } else {
                     d7 /= 2.0;
                     d8 /= 2.0;
                     this.r *= 0.2F;
                     this.t *= 0.2F;
                     this.c(d7 - d, 0.0, d8 - d1);
                     par1Entity.r *= 0.2F;
                     par1Entity.t *= 0.2F;
                     par1Entity.c(d7 + d, 0.0, d8 + d1);
                  }
               } else {
                  this.c(-d, 0.0, -d1);
                  par1Entity.c(d / 4.0, 0.0, d1 / 4.0);
               }
            }
         }
      }
   }

   public int a() {
      return 27;
   }

   public ItemStack k_(int par1) {
      return this.d[par1];
   }

   public ItemStack a(int par1, int par2) {
      if (this.d[par1] != null) {
         if (this.d[par1].a <= par2) {
            ItemStack itemstack = this.d[par1];
            this.d[par1] = null;
            return itemstack;
         }

         ItemStack itemstack1 = this.d[par1].a(par2);
         if (this.d[par1].a == 0) {
            this.d[par1] = null;
         }

         return itemstack1;
      } else {
         return null;
      }
   }

   public ItemStack b(int par1) {
      if (this.d[par1] != null) {
         ItemStack itemstack = this.d[par1];
         this.d[par1] = null;
         return itemstack;
      } else {
         return null;
      }
   }

   public void a(int par1, ItemStack par2ItemStack) {
      this.d[par1] = par2ItemStack;
      if (par2ItemStack != null && par2ItemStack.a > this.d()) {
         par2ItemStack.a = this.d();
      }
   }

   public String c() {
      return "container.minecart";
   }

   public int d() {
      return 64;
   }

   public void j() {
   }

   @Override
   public boolean c(EntityPlayer par1EntityPlayer) {
      if (this.a == 0) {
         if (this.i != null && this.i instanceof EntityPlayer && this.i != par1EntityPlayer) {
            return true;
         }

         if (!this.k.F) {
            par1EntityPlayer.h(this);
         }
      } else if (this.a == 1) {
         if (!this.k.F) {
            par1EntityPlayer.a(this);
         }
      } else if (this.a == 2) {
         ItemStack itemstack = par1EntityPlayer.ap.b();
         if (itemstack != null && itemstack.c == Item.m.bQ) {
            if (--itemstack.a == 0) {
               par1EntityPlayer.ap.a(par1EntityPlayer.ap.c, null);
            }

            this.e += 3600;
         }

         this.b = this.o - par1EntityPlayer.o;
         this.c = this.q - par1EntityPlayer.q;
      }

      return true;
   }

   @Override
   public void a(double par1, double par3, double par5, float par7, float par8, int par9) {
      this.ap = par1;
      this.aq = par3;
      this.ar = par5;
      this.as = par7;
      this.at = par8;
      this.GenLayerHills = par9 + 2;
      this.r = this.au;
      this.s = this.EntityThrowable;
      this.t = this.aw;
   }

   @Override
   public void a(double par1, double par3, double par5) {
      this.au = this.r = par1;
      this.EntityThrowable = this.s = par3;
      this.aw = this.t = par5;
   }

   public boolean a_(EntityPlayer par1EntityPlayer) {
      return this.G ? false : par1EntityPlayer.f(this) <= 64.0;
   }

   protected boolean n() {
      return (this.EntityNoteFX.a(16) & 1) != 0;
   }

   protected void a(boolean par1) {
      if (par1) {
         this.EntityNoteFX.b(16, (byte)(this.EntityNoteFX.a(16) | 1));
      } else {
         this.EntityNoteFX.b(16, (byte)(this.EntityNoteFX.a(16) & -2));
      }
   }

   public void e() {
   }

   public void f() {
   }

   public void c(int par1) {
      this.EntityNoteFX.b(19, par1);
   }

   public int o() {
      return this.EntityNoteFX.c(19);
   }

   public void d(int par1) {
      this.EntityNoteFX.b(17, par1);
   }

   public int p() {
      return this.EntityNoteFX.c(17);
   }

   public void h(int par1) {
      this.EntityNoteFX.b(18, par1);
   }

   public int r() {
      return this.EntityNoteFX.c(18);
   }
}
