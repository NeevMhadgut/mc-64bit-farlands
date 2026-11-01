import java.util.List;
import java.util.Random;

public abstract class Entity {
   private static int a = 0;
   public int f;
   public double g;
   public boolean h;
   public Entity i;
   public Entity j;
   public World k;
   public double l;
   public double m;
   public double n;
   public double o;
   public double p;
   public double q;
   public double r;
   public double s;
   public double t;
   public float u;
   public float v;
   public float w;
   public float x;
   public final AxisAlignedBB y = AxisAlignedBB.a(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
   public boolean z;
   public boolean A;
   public boolean B;
   public boolean C;
   public boolean D;
   protected boolean E;
   public boolean F;
   public boolean G;
   public float H;
   public float I;
   public float J;
   public float K;
   public float L;
   public float M;
   private int b;
   public double N;
   public double O;
   public double P;
   public float Q;
   public float R;
   public boolean S;
   public float T;
   protected Random U;
   public int V;
   public int W;
   private int c;
   protected boolean X;
   public int Y;
   private boolean d;
   public String Z;
   public String BlockSnowBlock;
   protected boolean ab;
   protected DataWatcher EntityNoteFX;
   private double e;
   private double NoiseGeneratorPerlin;
   public boolean ad;
   public long BlockTNT;
   public int TileEntityMobSpawnerRenderer;
   public long ag;
   public long ah;
   public int ai;
   public long aj;
   public boolean ak;
   public boolean BlockPortal;

   public Entity(World par1World) {
      this.f = a++;
      this.g = 1.0;
      this.h = false;
      this.z = false;
      this.C = false;
      this.D = false;
      this.F = true;
      this.G = false;
      this.H = 0.0F;
      this.I = 0.6F;
      this.J = 1.8F;
      this.K = 0.0F;
      this.L = 0.0F;
      this.M = 0.0F;
      this.b = 1;
      this.Q = 0.0F;
      this.R = 0.0F;
      this.S = false;
      this.T = 0.0F;
      this.U = new Random();
      this.V = 0;
      this.W = 1;
      this.c = 0;
      this.X = false;
      this.Y = 0;
      this.d = true;
      this.ab = false;
      this.EntityNoteFX = new DataWatcher();
      this.ad = false;
      this.k = par1World;
      this.d(0.0, 0.0, 0.0);
      this.EntityNoteFX.a(0, (byte)0);
      this.EntityNoteFX.a(1, (short)300);
      this.b();
   }

   protected abstract void b();

   public DataWatcher y() {
      return this.EntityNoteFX;
   }

   @Override
   public boolean equals(Object par1Obj) {
      return par1Obj instanceof Entity ? ((Entity)par1Obj).f == this.f : false;
   }

   @Override
   public int hashCode() {
      return this.f;
   }

   protected void z() {
      if (this.k != null) {
         while (!(this.p <= 0.0)) {
            this.d(this.o, this.p, this.q);
            if (this.k.a(this, this.y).size() == 0) {
               break;
            }

            this.p++;
         }

         this.r = this.s = this.t = 0.0;
         this.v = 0.0F;
      }
   }

   public void A() {
      this.G = true;
   }

   protected void a(float par1, float par2) {
      this.I = par1;
      this.J = par2;
   }

   protected void b(float par1, float par2) {
      this.u = par1 % 360.0F;
      this.v = par2 % 360.0F;
   }

   public void d(double par1, double par3, double par5) {
      this.o = par1;
      this.p = par3;
      this.q = par5;
      float f = this.I / 2.0F;
      float f1 = this.J;
      this.y.c(par1 - f, par3 - this.H + this.Q, par5 - f, par1 + f, par3 - this.H + this.Q + f1, par5 + f);
   }

   public void c(float par1, float par2) {
      float f = this.v;
      float f1 = this.u;
      this.u = (float)(this.u + par1 * 0.15);
      this.v = (float)(this.v - par2 * 0.15);
      if (this.v < -90.0F) {
         this.v = -90.0F;
      }

      if (this.v > 90.0F) {
         this.v = 90.0F;
      }

      this.x = this.x + (this.v - f);
      this.w = this.w + (this.u - f1);
      if (par1 == 0.0F) {
         this.u %= 360.0F;
         this.w %= 360.0F;
      }
   }

   public void J_() {
      this.B();
   }

   public void B() {
      lv.a("entityBaseTick");
      if (this.j != null && this.j.G) {
         this.j = null;
      }

      this.V++;
      this.K = this.L;
      this.l = this.o;
      this.m = this.p;
      this.n = this.q;
      this.x = this.v;
      this.w = this.u;
      if (this.W() && !this.H()) {
         long i = MathHelper.d(this.o);
         int j = MathHelper.c(this.p - 0.2F - this.H);
         long k = MathHelper.d(this.q);
         int j1 = this.k.getBlockId(i, j, k);
         int k1 = this.k.getBlockMetadata(i, j, k);
         if (j1 > 0) {
            this.k.stupidFuckingMethodSolelyForSprintingBecauseFuckMeIGuess(this, 0, i, j, k, j1, k1);
         }
      }

      if (this.g_()) {
         if (!this.X && !this.d) {
            float f = MathHelper.a(this.r * this.r * 0.2F + this.s * this.s + this.t * this.t * 0.2F) * 0.2F;
            if (f > 1.0F) {
               f = 1.0F;
            }

            this.k.a(this, "random.splash", f, 1.0F + (this.U.nextFloat() - this.U.nextFloat()) * 0.4F);
            float f1 = MathHelper.c(this.y.b);

            for (int l = 0; l < 1.0F + this.I * 20.0F; l++) {
               float f2 = (this.U.nextFloat() * 2.0F - 1.0F) * this.I;
               float f4 = (this.U.nextFloat() * 2.0F - 1.0F) * this.I;
               this.k.a("bubble", this.o + f2, f1 + 1.0F, this.q + f4, this.r, this.s - this.U.nextFloat() * 0.2F, this.t);
            }

            for (int i1 = 0; i1 < 1.0F + this.I * 20.0F; i1++) {
               float f3 = (this.U.nextFloat() * 2.0F - 1.0F) * this.I;
               float f5 = (this.U.nextFloat() * 2.0F - 1.0F) * this.I;
               this.k.a("splash", this.o + f3, f1 + 1.0F, this.q + f5, this.r, this.s, this.t);
            }
         }

         this.M = 0.0F;
         this.X = true;
         this.c = 0;
      } else {
         this.X = false;
      }

      if (this.k.F) {
         this.c = 0;
      } else if (this.c > 0) {
         if (this.ab) {
            this.c -= 4;
            if (this.c < 0) {
               this.c = 0;
            }
         } else {
            if (this.c % 20 == 0) {
               this.a(md.c, 1);
            }

            this.c--;
         }
      }

      if (this.J()) {
         this.C();
         this.M *= 0.5F;
      }

      if (this.p < -64.0) {
         this.E();
      }

      if (!this.k.F) {
         this.a(0, this.c > 0);
         this.a(2, this.j != null);
      }

      this.d = false;
      lv.b();
   }

   protected void C() {
      if (!this.ab) {
         this.a(md.d, 4);
         this.e(15);
      }
   }

   public void e(int par1) {
      int i = par1 * 20;
      if (this.c < i) {
         this.c = i;
      }
   }

   public void D() {
      this.c = 0;
   }

   protected void E() {
      this.A();
   }

   public boolean e(double par1, double par3, double par5) {
      AxisAlignedBB axisalignedbb = this.y.c(par1, par3, par5);
      List list = this.k.a(this, axisalignedbb);
      return list.size() > 0 ? false : !this.k.b(axisalignedbb);
   }

   public void b(double par1, double par3, double par5) {
      if (this.S) {
         this.y.d(par1, par3, par5);
         this.o = (this.y.a + this.y.d) / 2.0;
         this.p = this.y.b + this.H - this.Q;
         this.q = (this.y.c + this.y.f) / 2.0;
      } else {
         lv.a("move");
         this.Q *= 0.4F;
         double d = this.o;
         double d1 = this.q;
         if (this.E) {
            this.E = false;
            par1 *= 0.25;
            par3 *= 0.05F;
            par5 *= 0.25;
            this.r = 0.0;
            this.s = 0.0;
            this.t = 0.0;
         }

         double d2 = par1;
         double d3 = par3;
         double d4 = par5;
         AxisAlignedBB axisalignedbb = this.y.d();
         boolean flag = this.z && this.V() && this instanceof EntityPlayer;
         if (flag) {
            double d5 = 0.05;

            while (par1 != 0.0 && this.k.a(this, this.y.c(par1, -1.0, 0.0)).size() == 0) {
               if (par1 < d5 && par1 >= -d5) {
                  par1 = 0.0;
               } else if (par1 > 0.0) {
                  par1 -= d5;
               } else {
                  par1 += d5;
               }

               d2 = par1;
            }

            for (; par5 != 0.0 && this.k.a(this, this.y.c(0.0, -1.0, par5)).size() == 0; d4 = par5) {
               if (par5 < d5 && par5 >= -d5) {
                  par5 = 0.0;
               } else if (par5 > 0.0) {
                  par5 -= d5;
               } else {
                  par5 += d5;
               }
            }

            while (par1 != 0.0 && par5 != 0.0 && this.k.a(this, this.y.c(par1, -1.0, par5)).size() == 0) {
               if (par1 < d5 && par1 >= -d5) {
                  par1 = 0.0;
               } else if (par1 > 0.0) {
                  par1 -= d5;
               } else {
                  par1 += d5;
               }

               if (par5 < d5 && par5 >= -d5) {
                  par5 = 0.0;
               } else if (par5 > 0.0) {
                  par5 -= d5;
               } else {
                  par5 += d5;
               }

               d2 = par1;
               d4 = par5;
            }
         }

         List list = this.k.a(this, this.y.a(par1, par3, par5));

         for (int i = 0; i < list.size(); i++) {
            par3 = ((AxisAlignedBB)list.get(i)).b(this.y, par3);
         }

         this.y.d(0.0, par3, 0.0);
         if (!this.F && d3 != par3) {
            par5 = 0.0;
            par3 = 0.0;
            par1 = 0.0;
         }

         boolean flag1 = this.z || d3 != par3 && d3 < 0.0;

         for (int j = 0; j < list.size(); j++) {
            par1 = ((AxisAlignedBB)list.get(j)).a(this.y, par1);
         }

         this.y.d(par1, 0.0, 0.0);
         if (!this.F && d2 != par1) {
            par5 = 0.0;
            par3 = 0.0;
            par1 = 0.0;
         }

         for (int k = 0; k < list.size(); k++) {
            par5 = ((AxisAlignedBB)list.get(k)).c(this.y, par5);
         }

         this.y.d(0.0, 0.0, par5);
         if (!this.F && d4 != par5) {
            par5 = 0.0;
            par3 = 0.0;
            par1 = 0.0;
         }

         if (this.R > 0.0F && flag1 && (flag || this.Q < 0.05F) && (d2 != par1 || d4 != par5)) {
            double d6 = par1;
            double d8 = par3;
            double d10 = par5;
            par1 = d2;
            par3 = this.R;
            par5 = d4;
            AxisAlignedBB axisalignedbb1 = this.y.d();
            this.y.b(axisalignedbb);
            List list1 = this.k.a(this, this.y.a(par1, par3, par5));

            for (int j2 = 0; j2 < list1.size(); j2++) {
               par3 = ((AxisAlignedBB)list1.get(j2)).b(this.y, par3);
            }

            this.y.d(0.0, par3, 0.0);
            if (!this.F && d3 != par3) {
               par5 = 0.0;
               par3 = 0.0;
               par1 = 0.0;
            }

            for (int k2 = 0; k2 < list1.size(); k2++) {
               par1 = ((AxisAlignedBB)list1.get(k2)).a(this.y, par1);
            }

            this.y.d(par1, 0.0, 0.0);
            if (!this.F && d2 != par1) {
               par5 = 0.0;
               par3 = 0.0;
               par1 = 0.0;
            }

            for (int l2 = 0; l2 < list1.size(); l2++) {
               par5 = ((AxisAlignedBB)list1.get(l2)).c(this.y, par5);
            }

            this.y.d(0.0, 0.0, par5);
            if (!this.F && d4 != par5) {
               par5 = 0.0;
               par3 = 0.0;
               par1 = 0.0;
            }

            if (!this.F && d3 != par3) {
               par5 = 0.0;
               par3 = 0.0;
               par1 = 0.0;
            } else {
               par3 = -this.R;

               for (int i3 = 0; i3 < list1.size(); i3++) {
                  par3 = ((AxisAlignedBB)list1.get(i3)).b(this.y, par3);
               }

               this.y.d(0.0, par3, 0.0);
            }

            if (d6 * d6 + d10 * d10 >= par1 * par1 + par5 * par5) {
               par1 = d6;
               par3 = d8;
               par5 = d10;
               this.y.b(axisalignedbb1);
            } else {
               double d11 = this.y.b - (int)this.y.b;
               if (d11 > 0.0) {
                  this.Q = (float)(this.Q + (d11 + 0.01));
               }
            }
         }

         lv.b();
         lv.a("rest");
         this.o = (this.y.a + this.y.d) / 2.0;
         this.p = this.y.b + this.H - this.Q;
         this.q = (this.y.c + this.y.f) / 2.0;
         this.A = d2 != par1 || d4 != par5;
         this.B = d3 != par3;
         this.z = d3 != par3 && d3 < 0.0;
         this.C = this.A || this.B;
         this.a(par3, this.z);
         if (d2 != par1) {
            this.r = 0.0;
         }

         if (d3 != par3) {
            this.s = 0.0;
         }

         if (d4 != par5) {
            this.t = 0.0;
         }

         double d7 = this.o - d;
         double d9 = this.q - d1;
         if (this.e_() && !flag && this.j == null) {
            this.L = (float)(this.L + MathHelper.a(d7 * d7 + d9 * d9) * 0.6);
            long l = MathHelper.d(this.o);
            int j1 = MathHelper.c(this.p - 0.2F - this.H);
            long l1 = MathHelper.d(this.q);
            int j3 = this.k.getBlockId(l, j1, l1);
            if (j3 == 0 && this.k.getBlockId(l, j1 - 1, l1) == Block.aZ.bO) {
               j3 = this.k.getBlockId(l, j1 - 1, l1);
            }

            if (this.L > this.b && j3 > 0) {
               this.b = (int)this.L + 1;
               this.playStepSound(l, j1, l1, j3);
               Block.m[j3].onEntityWalking(this.k, l, j1, l1, this);
            }
         }

         long i1 = MathHelper.d(this.y.a + 0.001);
         int k1 = MathHelper.c(this.y.b + 0.001);
         long i2 = MathHelper.d(this.y.c + 0.001);
         long k3 = MathHelper.d(this.y.d - 0.001);
         int l3 = MathHelper.c(this.y.e - 0.001);
         long i4 = MathHelper.d(this.y.f - 0.001);
         if (this.k.checkChunksExist(i1, k1, i2, k3, l3, i4)) {
            for (long j4 = i1; j4 >= i1 && j4 <= k3; j4++) {
               for (int k4 = k1; k4 <= l3; k4++) {
                  for (long l4 = i2; l4 >= i2 && l4 <= i4; l4++) {
                     int i5 = this.k.getBlockId(j4, k4, l4);
                     if (i5 > 0) {
                        Block.m[i5].onEntityCollidedWithBlock(this.k, j4, k4, l4, this);
                     }
                  }
               }
            }
         }

         boolean flag2 = this.G();
         if (this.k.c(this.y.e(0.001, 0.001, 0.001))) {
            this.a(1);
            if (!flag2) {
               this.c++;
               if (this.c == 0) {
                  this.e(8);
               }
            }
         } else if (this.c <= 0) {
            this.c = -this.W;
         }

         if (flag2 && this.c > 0) {
            this.k.a(this, "random.fizz", 0.7F, 1.6F + (this.U.nextFloat() - this.U.nextFloat()) * 0.4F);
            this.c = -this.W;
         }

         lv.b();
      }
   }

   protected void playStepSound(long par1, int par2, long par3, int par4) {
      vj stepsound = Block.m[par4].cb;
      if (this.k.getBlockId(par1, par2 + 1, par3) == Block.aS.bO) {
         stepsound = Block.aS.cb;
         this.k.a(this, stepsound.d(), stepsound.b() * 0.15F, stepsound.c());
      } else if (!Block.m[par4].cd.d()) {
         this.k.a(this, stepsound.d(), stepsound.b() * 0.15F, stepsound.c());
      }
   }

   protected boolean e_() {
      return true;
   }

   protected void a(double par1, boolean par3) {
      if (par3) {
         if (this.M > 0.0F) {
            if (this instanceof EntityLiving) {
               long i = MathHelper.d(this.o);
               int j = MathHelper.c(this.p - 0.2F - this.H);
               long k = MathHelper.d(this.q);
               int l = this.k.getBlockId(i, j, k);
               if (l == 0 && this.k.getBlockId(i, j - 1, k) == Block.aZ.bO) {
                  l = this.k.getBlockId(i, j - 1, k);
               }

               if (l > 0) {
                  Block.m[l].onFallenUpon(this.k, i, j, k, this, this.M);
               }
            }

            this.e(this.M);
            this.M = 0.0F;
         }
      } else if (par1 < 0.0) {
         this.M = (float)(this.M - par1);
      }
   }

   public AxisAlignedBB f_() {
      return null;
   }

   protected void a(int par1) {
      if (!this.ab) {
         this.a(md.b, par1);
      }
   }

   public final boolean F() {
      return this.ab;
   }

   protected void e(float par1) {
      if (this.i != null) {
         this.i.e(par1);
      }
   }

   public boolean G() {
      return this.X || this.k.canLightningStrikeAt(MathHelper.d(this.o), MathHelper.c(this.p), MathHelper.d(this.q));
   }

   public boolean H() {
      return this.X;
   }

   public boolean g_() {
      return this.k.a(this.y.b(0.0, -0.4F, 0.0).e(0.001, 0.001, 0.001), acn.g, this);
   }

   public boolean a(acn par1Material) {
      double d = this.p + this.I();
      long i = MathHelper.d(this.o);
      int j = MathHelper.d(MathHelper.c(d));
      long k = MathHelper.d(this.q);
      int l = this.k.getBlockId(i, j, k);
      if (l != 0 && Block.m[l].cd == par1Material) {
         float f = BlockFluid.e(this.k.getBlockMetadata(i, j, k)) - 0.1111111F;
         float f1 = j + 1 - f;
         return d < f1;
      } else {
         return false;
      }
   }

   public float I() {
      return 0.0F;
   }

   public boolean J() {
      return this.k.a(this.y.b(-0.1F, -0.4F, -0.1F), acn.h);
   }

   public void a(float par1, float par2, float par3) {
      float f = MathHelper.c(par1 * par1 + par2 * par2);
      if (!(f < 0.01F)) {
         if (f < 1.0F) {
            f = 1.0F;
         }

         f = par3 / f;
         par1 *= f;
         par2 *= f;
         float f1 = MathHelper.a(this.u * (float) Math.PI / 180.0F);
         float f2 = MathHelper.b(this.u * (float) Math.PI / 180.0F);
         this.r += par1 * f2 - par2 * f1;
         this.t += par2 * f2 + par1 * f1;
      }
   }

   public int b(float par1) {
      long i = MathHelper.d(this.o);
      long j = MathHelper.d(this.q);
      if (this.k.blockExists(i, 0, j)) {
         double d = (this.y.e - this.y.b) * 0.66;
         int k = MathHelper.c(this.p - this.H + d);
         return this.k.getLightBrightnessForSkyBlocks(i, k, j, 0);
      } else {
         return 0;
      }
   }

   public float a(float par1) {
      long i = MathHelper.d(this.o);
      long j = MathHelper.d(this.q);
      if (this.k.blockExists(i, 0, j)) {
         double d = (this.y.e - this.y.b) * 0.66;
         int k = MathHelper.c(this.p - this.H + d);
         return this.k.getLightBrightness(i, k, j);
      } else {
         return 0.0F;
      }
   }

   public void a(World par1World) {
      this.k = par1World;
   }

   public void b(double par1, double par3, double par5, float par7, float par8) {
      this.l = this.o = par1;
      this.m = this.p = par3;
      this.n = this.q = par5;
      this.w = this.u = par7;
      this.x = this.v = par8;
      this.Q = 0.0F;
      double d = this.w - par7;
      if (d < -180.0) {
         this.w += 360.0F;
      }

      if (d >= 180.0) {
         this.w -= 360.0F;
      }

      this.d(this.o, this.p, this.q);
      this.b(par7, par8);
   }

   public void c(double par1, double par3, double par5, float par7, float par8) {
      this.N = this.l = this.o = par1;
      this.O = this.m = this.p = par3 + this.H;
      this.P = this.n = this.q = par5;
      this.u = par7;
      this.v = par8;
      this.d(this.o, this.p, this.q);
   }

   public float e(Entity par1Entity) {
      float f = (float)(this.o - par1Entity.o);
      float f1 = (float)(this.p - par1Entity.p);
      float f2 = (float)(this.q - par1Entity.q);
      return MathHelper.c(f * f + f1 * f1 + f2 * f2);
   }

   public double f(double par1, double par3, double par5) {
      double d = this.o - par1;
      double d1 = this.p - par3;
      double d2 = this.q - par5;
      return d * d + d1 * d1 + d2 * d2;
   }

   public double g(double par1, double par3, double par5) {
      double d = this.o - par1;
      double d1 = this.p - par3;
      double d2 = this.q - par5;
      return MathHelper.a(d * d + d1 * d1 + d2 * d2);
   }

   public double f(Entity par1Entity) {
      double d = this.o - par1Entity.o;
      double d1 = this.p - par1Entity.p;
      double d2 = this.q - par1Entity.q;
      return d * d + d1 * d1 + d2 * d2;
   }

   public void a(EntityPlayer entityplayer) {
   }

   public void g(Entity par1Entity) {
      if (par1Entity.i != this && par1Entity.j != this) {
         double d = par1Entity.o - this.o;
         double d1 = par1Entity.q - this.q;
         double d2 = MathHelper.a(d, d1);
         if (d2 >= 0.01F) {
            d2 = MathHelper.a(d2);
            d /= d2;
            d1 /= d2;
            double d3 = 1.0 / d2;
            if (d3 > 1.0) {
               d3 = 1.0;
            }

            d *= d3;
            d1 *= d3;
            d *= 0.05F;
            d1 *= 0.05F;
            d *= 1.0F - this.T;
            d1 *= 1.0F - this.T;
            this.c(-d, 0.0, -d1);
            par1Entity.c(d, 0.0, d1);
         }
      }
   }

   public void c(double par1, double par3, double par5) {
      this.r += par1;
      this.s += par3;
      this.t += par5;
      this.BlockPortal = true;
   }

   protected void K() {
      this.D = true;
   }

   public boolean a(md par1DamageSource, int par2) {
      this.K();
      return false;
   }

   public boolean l_() {
      return false;
   }

   public boolean d_() {
      return false;
   }

   public void a(Entity entity, int i) {
   }

   public boolean a(bo par1Vec3D) {
      double d = this.o - par1Vec3D.a;
      double d1 = this.p - par1Vec3D.b;
      double d2 = this.q - par1Vec3D.c;
      double d3 = d * d + d1 * d1 + d2 * d2;
      return this.a(d3);
   }

   public boolean a(double par1) {
      double d = this.y.c();
      d *= 64.0 * this.g;
      return par1 < d * d;
   }

   public String v_() {
      return null;
   }

   public boolean c(ady par1NBTTagCompound) {
      String s = this.L();
      if (!this.G && s != null) {
         par1NBTTagCompound.a("id", s);
         this.d(par1NBTTagCompound);
         return true;
      } else {
         return false;
      }
   }

   public void d(ady par1NBTTagCompound) {
      par1NBTTagCompound.a("Pos", this.a(new double[]{this.o, this.p + this.Q, this.q}));
      par1NBTTagCompound.a("Motion", this.a(new double[]{this.r, this.s, this.t}));
      par1NBTTagCompound.a("Rotation", this.a(new float[]{this.u, this.v}));
      par1NBTTagCompound.a("FallDistance", this.M);
      par1NBTTagCompound.a("Fire", (short)this.c);
      par1NBTTagCompound.a("Air", (short)this.Y());
      par1NBTTagCompound.a("OnGround", this.z);
      this.b(par1NBTTagCompound);
   }

   public void e(ady par1NBTTagCompound) {
      no nbttaglist = par1NBTTagCompound.n("Pos");
      no nbttaglist1 = par1NBTTagCompound.n("Motion");
      no nbttaglist2 = par1NBTTagCompound.n("Rotation");
      this.r = ((ahl)nbttaglist1.a(0)).a;
      this.s = ((ahl)nbttaglist1.a(1)).a;
      this.t = ((ahl)nbttaglist1.a(2)).a;
      if (Math.abs(this.r) > 10.0) {
         this.r = 0.0;
      }

      if (Math.abs(this.s) > 10.0) {
         this.s = 0.0;
      }

      if (Math.abs(this.t) > 10.0) {
         this.t = 0.0;
      }

      this.l = this.N = this.o = ((ahl)nbttaglist.a(0)).a;
      this.m = this.O = this.p = ((ahl)nbttaglist.a(1)).a;
      this.n = this.P = this.q = ((ahl)nbttaglist.a(2)).a;
      this.w = this.u = ((m)nbttaglist2.a(0)).a;
      this.x = this.v = ((m)nbttaglist2.a(1)).a;
      this.M = par1NBTTagCompound.h("FallDistance");
      this.c = par1NBTTagCompound.e("Fire");
      this.g(par1NBTTagCompound.e("Air"));
      this.z = par1NBTTagCompound.o("OnGround");
      this.d(this.o, this.p, this.q);
      this.b(this.u, this.v);
      this.a(par1NBTTagCompound);
   }

   protected final String L() {
      return EntityList.b(this);
   }

   protected abstract void a(ady var1);

   protected abstract void b(ady var1);

   protected no a(double[] par1ArrayOfDouble) {
      no nbttaglist = new no();

      for (double d : par1ArrayOfDouble) {
         nbttaglist.a(new ahl(null, d));
      }

      return nbttaglist;
   }

   protected no a(float[] par1ArrayOfFloat) {
      no nbttaglist = new no();

      for (float f : par1ArrayOfFloat) {
         nbttaglist.a(new m(null, f));
      }

      return nbttaglist;
   }

   public float h_() {
      return this.J / 2.0F;
   }

   public EntityItem b(int par1, int par2) {
      return this.a(par1, par2, 0.0F);
   }

   public EntityItem a(int par1, int par2, float par3) {
      return this.a(new ItemStack(par1, par2, 0), par3);
   }

   public EntityItem a(ItemStack par1ItemStack, float par2) {
      EntityItem entityitem = new EntityItem(this.k, this.o, this.p + par2, this.q, par1ItemStack);
      entityitem.c = 10;
      this.k.a(entityitem);
      return entityitem;
   }

   public boolean M() {
      return !this.G;
   }

   public boolean N() {
      for (int i = 0; i < 8; i++) {
         float f = ((i >> 0) % 2 - 0.5F) * this.I * 0.8F;
         float f1 = ((i >> 1) % 2 - 0.5F) * 0.1F;
         float f2 = ((i >> 2) % 2 - 0.5F) * this.I * 0.8F;
         long j = MathHelper.d(this.o + f);
         int k = MathHelper.c(this.p + this.I() + f1);
         long l = MathHelper.d(this.q + f2);
         if (this.k.isBlockNormalCube(j, k, l)) {
            return true;
         }
      }

      return false;
   }

   public boolean c(EntityPlayer par1EntityPlayer) {
      return false;
   }

   public AxisAlignedBB b(Entity par1Entity) {
      return null;
   }

   public void O() {
      if (this.j.G) {
         this.j = null;
      } else {
         this.r = 0.0;
         this.s = 0.0;
         this.t = 0.0;
         this.J_();
         if (this.j != null) {
            this.j.i_();
            this.NoiseGeneratorPerlin = this.NoiseGeneratorPerlin + (this.j.u - this.j.w);
            this.e = this.e + (this.j.v - this.j.x);

            while (this.NoiseGeneratorPerlin >= 180.0) {
               this.NoiseGeneratorPerlin -= 360.0;
            }

            while (this.NoiseGeneratorPerlin < -180.0) {
               this.NoiseGeneratorPerlin += 360.0;
            }

            while (this.e >= 180.0) {
               this.e -= 360.0;
            }

            while (this.e < -180.0) {
               this.e += 360.0;
            }

            double d = this.NoiseGeneratorPerlin * 0.5;
            double d1 = this.e * 0.5;
            float f = 10.0F;
            if (d > f) {
               d = f;
            }

            if (d < -f) {
               d = -f;
            }

            if (d1 > f) {
               d1 = f;
            }

            if (d1 < -f) {
               d1 = -f;
            }

            this.NoiseGeneratorPerlin -= d;
            this.e -= d1;
            this.u = (float)(this.u + d);
            this.v = (float)(this.v + d1);
         }
      }
   }

   public void i_() {
      this.i.d(this.o, this.p + this.l() + this.i.P(), this.q);
   }

   public double P() {
      return this.H;
   }

   public double l() {
      return this.J * 0.75;
   }

   public void h(Entity par1Entity) {
      this.e = 0.0;
      this.NoiseGeneratorPerlin = 0.0;
      if (par1Entity == null) {
         if (this.j != null) {
            this.c(this.j.o, this.j.y.b + this.j.J, this.j.q, this.u, this.v);
            this.j.i = null;
         }

         this.j = null;
      } else if (this.j == par1Entity) {
         this.j.i = null;
         this.j = null;
         this.c(par1Entity.o, par1Entity.y.b + par1Entity.J, par1Entity.q, this.u, this.v);
      } else {
         if (this.j != null) {
            this.j.i = null;
         }

         if (par1Entity.i != null) {
            par1Entity.i.j = null;
         }

         this.j = par1Entity;
         par1Entity.i = this;
      }
   }

   public void a(double par1, double par3, double par5, float par7, float par8, int par9) {
      this.d(par1, par3, par5);
      this.b(par7, par8);
      List list = this.k.a(this, this.y.e(0.03125, 0.0, 0.03125));
      if (list.size() > 0) {
         double d = 0.0;

         for (int i = 0; i < list.size(); i++) {
            AxisAlignedBB axisalignedbb = (AxisAlignedBB)list.get(i);
            if (axisalignedbb.e > d) {
               d = axisalignedbb.e;
            }
         }

         par3 += d - this.y.b;
         this.d(par1, par3, par5);
      }
   }

   public float j_() {
      return 0.1F;
   }

   public bo Q() {
      return null;
   }

   public void R() {
   }

   public void a(double par1, double par3, double par5) {
      this.r = par1;
      this.s = par3;
      this.t = par5;
   }

   public void a(byte byte0) {
   }

   public void k() {
   }

   public void S() {
   }

   public void b(int i, int j, int k) {
   }

   public boolean T() {
      return this.c > 0 || this.f(0);
   }

   public boolean U() {
      return this.j != null || this.f(2);
   }

   public boolean V() {
      return this.f(1);
   }

   public void c(boolean par1) {
      this.a(1, par1);
   }

   public boolean W() {
      return this.f(3);
   }

   public void d(boolean par1) {
      this.a(3, par1);
   }

   public boolean X() {
      return this.f(4);
   }

   public void e(boolean par1) {
      this.a(4, par1);
   }

   protected boolean f(int par1) {
      return (this.EntityNoteFX.a(0) & 1 << par1) != 0;
   }

   protected void a(int par1, boolean par2) {
      byte byte0 = this.EntityNoteFX.a(0);
      if (par2) {
         this.EntityNoteFX.b(0, (byte)(byte0 | 1 << par1));
      } else {
         this.EntityNoteFX.b(0, (byte)(byte0 & ~(1 << par1)));
      }
   }

   public int Y() {
      return this.EntityNoteFX.b(1);
   }

   public void g(int par1) {
      this.EntityNoteFX.b(1, (short)par1);
   }

   public void a(d par1EntityLightningBolt) {
      this.a(5);
      this.c++;
      if (this.c == 0) {
         this.e(8);
      }
   }

   public void b(EntityLiving entityliving) {
   }

   protected boolean h(double par1, double par3, double par5) {
      long i = MathHelper.d(par1);
      int j = MathHelper.c(par3);
      long k = MathHelper.d(par5);
      double d = par1 - i;
      double d1 = par3 - j;
      double d2 = par5 - k;
      if (this.k.isBlockNormalCube(i, j, k)) {
         boolean flag = !this.k.isBlockNormalCube(i - 1L, j, k);
         boolean flag1 = !this.k.isBlockNormalCube(i + 1L, j, k);
         boolean flag2 = !this.k.isBlockNormalCube(i, j - 1, k);
         boolean flag3 = !this.k.isBlockNormalCube(i, j + 1, k);
         boolean flag4 = !this.k.isBlockNormalCube(i, j, k - 1L);
         boolean flag5 = !this.k.isBlockNormalCube(i, j, k + 1L);
         byte byte0 = -1;
         double d3 = 9999.0;
         if (flag && d < d3) {
            d3 = d;
            byte0 = 0;
         }

         if (flag1 && 1.0 - d < d3) {
            d3 = 1.0 - d;
            byte0 = 1;
         }

         if (flag2 && d1 < d3) {
            d3 = d1;
            byte0 = 2;
         }

         if (flag3 && 1.0 - d1 < d3) {
            d3 = 1.0 - d1;
            byte0 = 3;
         }

         if (flag4 && d2 < d3) {
            d3 = d2;
            byte0 = 4;
         }

         if (flag5 && 1.0 - d2 < d3) {
            double d4 = 1.0 - d2;
            byte0 = 5;
         }

         float f = this.U.nextFloat() * 0.2F + 0.1F;
         if (byte0 == 0) {
            this.r = -f;
         }

         if (byte0 == 1) {
            this.r = f;
         }

         if (byte0 == 2) {
            this.s = -f;
         }

         if (byte0 == 3) {
            this.s = f;
         }

         if (byte0 == 4) {
            this.t = -f;
         }

         if (byte0 == 5) {
            this.t = f;
         }

         return true;
      } else {
         return false;
      }
   }

   public void q() {
      this.E = true;
      this.M = 0.0F;
   }

   public Entity[] Z() {
      return null;
   }

   public boolean a(Entity par1Entity) {
      return this == par1Entity;
   }

   public void f(float f) {
   }

   public boolean k_() {
      return true;
   }
}
