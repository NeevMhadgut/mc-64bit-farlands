import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public abstract class EntityLiving extends Entity {
   public int ba = 20;
   public float ItemBucket;
   public float EntityAnimal;
   public float bd = 0.0F;
   public float be = 0.0F;
   public float WorldGenSwamp = 0.0F;
   public float bg = 0.0F;
   protected float ItemShears;
   protected float bi;
   protected float EntityPotion;
   protected float bk;
   protected boolean bl = true;
   protected String bm = "/mob/char.png";
   protected boolean BiomeGenJungle = true;
   protected float bo = 0.0F;
   protected String EntityAIMoveIndoors = null;
   protected float bq = 1.0F;
   protected int br = 0;
   protected float bs = 0.0F;
   public float EntityFireball = 0.1F;
   public float bu = 0.02F;
   public float bv;
   public float bw;
   protected int bx;
   public int by;
   protected int EntityXPOrb;
   private int a;
   public int bA;
   public int bB;
   public float bC = 0.0F;
   public int bD = 0;
   public int bE = 0;
   public float bF;
   public float bG;
   protected boolean bH = false;
   protected int bI;
   public int bJ = -1;
   public float bK = (float)(Math.random() * 0.9F + 0.1F);
   public float bL;
   public float bM;
   public float bN;
   protected EntityPlayer bO = null;
   protected int bP = 0;
   private EntityLiving b = null;
   private int c = 0;
   private EntityLiving d = null;
   public int bQ = 0;
   public int bR = 0;
   protected HashMap bS = new HashMap();
   private boolean e = true;
   private int NoiseGeneratorPerlin;
   private vz MapGenVillage;
   private j GenLayerHills;
   private aej ap;
   private vh aq;
   private PathNavigate ar;
   protected nb bT = new nb();
   protected nb bU = new nb();
   private EntityLiving as;
   private abk at;
   private float au;
   private ChunkCoordinates EntityThrowable = new ChunkCoordinates(0L, 0, 0L);
   private float aw = -1.0F;
   protected int bV;
   protected double bW;
   protected double bX;
   protected double bY;
   protected double bZ;
   protected double IChunkProvider;
   float cb = 0.0F;
   protected int cc = 0;
   protected int cd = 0;
   protected float ce;
   protected float cf;
   protected float cg;
   protected boolean ch = false;
   protected float ci = 0.0F;
   protected float TileEntityMobSpawner = 0.7F;
   private int EntityAIAttackOnCollide = 0;
   private Entity StructureNetherBridgeStart;
   protected int ThreadDownloadResources = 0;

   public EntityLiving(World par1World) {
      super(par1World);
      this.bx = this.d();
      this.h = true;
      this.MapGenVillage = new vz(this);
      this.GenLayerHills = new j(this);
      this.ap = new aej(this);
      this.aq = new vh(this);
      this.ar = new PathNavigate(this, par1World, 16.0F);
      this.at = new abk(this);
      this.EntityAnimal = (float)(Math.random() + 1.0) * 0.01F;
      this.d(this.o, this.p, this.q);
      this.ItemBucket = (float)Math.random() * 12398.0F;
      this.u = (float)(Math.random() * Math.PI * 2.0);
      this.WorldGenSwamp = this.u;
      this.R = 0.5F;
   }

   public vz aJ() {
      return this.MapGenVillage;
   }

   public j aK() {
      return this.GenLayerHills;
   }

   public aej aL() {
      return this.ap;
   }

   public PathNavigate aM() {
      return this.ar;
   }

   public abk aN() {
      return this.at;
   }

   public Random aO() {
      return this.U;
   }

   public EntityLiving aP() {
      return this.b;
   }

   public EntityLiving aQ() {
      return this.d;
   }

   public void l(Entity par1Entity) {
      if (par1Entity instanceof EntityLiving) {
         this.d = (EntityLiving)par1Entity;
      }
   }

   public int aR() {
      return this.cd;
   }

   @Override
   public void f(float par1) {
      this.WorldGenSwamp = par1;
   }

   public float aS() {
      return this.au;
   }

   public void g(float par1) {
      this.au = par1;
      this.h(par1);
   }

   public boolean c(Entity par1Entity) {
      this.l(par1Entity);
      return false;
   }

   public EntityLiving aT() {
      return this.as;
   }

   public void c(EntityLiving par1EntityLiving) {
      this.as = par1EntityLiving;
   }

   public boolean a(Class par1Class) {
      return yd.class != par1Class && EntityGhast.class != par1Class;
   }

   public void v() {
   }

   public boolean aU() {
      return this.isWithinHomeDistance(MathHelper.d(this.o), MathHelper.c(this.p), MathHelper.d(this.q));
   }

   public boolean isWithinHomeDistance(long par1, int par2, long par3) {
      return this.aw == -1.0F ? true : this.EntityThrowable.getDistanceSquared(par1, par2, par3) < this.aw * this.aw;
   }

   public void setHomeArea(long par1, int par2, long par3, int par4) {
      this.EntityThrowable.set(par1, par2, par3);
      this.aw = par4;
   }

   public ChunkCoordinates aV() {
      return this.EntityThrowable;
   }

   public float aW() {
      return this.aw;
   }

   public void aX() {
      this.aw = -1.0F;
   }

   public boolean aY() {
      return this.aw != -1.0F;
   }

   public void a(EntityLiving par1EntityLiving) {
      this.b = par1EntityLiving;
      this.c = this.b == null ? 0 : 60;
   }

   @Override
   protected void b() {
      this.EntityNoteFX.a(8, this.NoiseGeneratorPerlin);
   }

   public boolean m(Entity par1Entity) {
      return this.k.a(bo.b(this.o, this.p + this.I(), this.q), bo.b(par1Entity.o, par1Entity.p + par1Entity.I(), par1Entity.q)) == null;
   }

   @Override
   public String v_() {
      return this.bm;
   }

   @Override
   public boolean l_() {
      return !this.G;
   }

   @Override
   public boolean d_() {
      return !this.G;
   }

   @Override
   public float I() {
      return this.J * 0.85F;
   }

   public int j() {
      return 80;
   }

   public void aZ() {
      String s = this.m();
      if (s != null) {
         this.k.a(this, s, this.C_(), this.TileEntityMobSpawnerRenderer());
      }
   }

   @Override
   public void B() {
      this.bv = this.bw;
      super.B();
      lv.a("mobBaseTick");
      if (this.M() && this.U.nextInt(1000) < this.a++) {
         this.a = -this.j();
         this.aZ();
      }

      if (this.M() && this.N() && !this.a(md.e, 1)) {
      }

      if (this.F() || this.k.F) {
         this.D();
      }

      if (this.M() && this.a(acn.g) && !this.r_() && !this.bS.containsKey(aad.o.H)) {
         this.g(this.b(this.Y()));
         if (this.Y() == -20) {
            this.g(0);

            for (int i = 0; i < 8; i++) {
               float f = this.U.nextFloat() - this.U.nextFloat();
               float f1 = this.U.nextFloat() - this.U.nextFloat();
               float f2 = this.U.nextFloat() - this.U.nextFloat();
               this.k.a("bubble", this.o + f, this.p + f1, this.q + f2, this.r, this.s, this.t);
            }

            this.a(md.f, 2);
         }

         this.D();
      } else {
         this.g(300);
      }

      this.bF = this.bG;
      if (this.bE > 0) {
         this.bE--;
      }

      if (this.bA > 0) {
         this.bA--;
      }

      if (this.Y > 0) {
         this.Y--;
      }

      if (this.bx <= 0) {
         this.w_();
      }

      if (this.bP > 0) {
         this.bP--;
      } else {
         this.bO = null;
      }

      if (this.d != null && !this.d.M()) {
         this.d = null;
      }

      if (this.b != null) {
         if (!this.b.M()) {
            this.a((EntityLiving)null);
         } else if (this.c > 0) {
            this.c--;
         } else {
            this.a((EntityLiving)null);
         }
      }

      this.be();
      this.bk = this.EntityPotion;
      this.be = this.bd;
      this.bg = this.WorldGenSwamp;
      this.w = this.u;
      this.x = this.v;
      lv.b();
   }

   protected void w_() {
      this.bD++;
      if (this.bD == 20) {
         if (!this.k.F && (this.bP > 0 || this.aH()) && !this.bi()) {
            int i = this.b(this.bO);

            while (i > 0) {
               int k = EntityXPOrb.b(i);
               i -= k;
               this.k.a(new EntityXPOrb(this.k, this.o, this.p, this.q, k));
            }
         }

         this.EntityAnimal();
         this.A();

         for (int j = 0; j < 20; j++) {
            double d = this.U.nextGaussian() * 0.02;
            double d1 = this.U.nextGaussian() * 0.02;
            double d2 = this.U.nextGaussian() * 0.02;
            this.k
               .a(
                  "explode",
                  this.o + this.U.nextFloat() * this.I * 2.0F - this.I,
                  this.p + this.U.nextFloat() * this.J,
                  this.q + this.U.nextFloat() * this.I * 2.0F - this.I,
                  d,
                  d1,
                  d2
               );
         }
      }
   }

   protected int b(int par1) {
      return par1 - 1;
   }

   protected int b(EntityPlayer par1EntityPlayer) {
      return this.bI;
   }

   protected boolean aH() {
      return false;
   }

   public void ba() {
      for (int i = 0; i < 20; i++) {
         double d = this.U.nextGaussian() * 0.02;
         double d1 = this.U.nextGaussian() * 0.02;
         double d2 = this.U.nextGaussian() * 0.02;
         double d3 = 10.0;
         this.k
            .a(
               "explode",
               this.o + this.U.nextFloat() * this.I * 2.0F - this.I - d * d3,
               this.p + this.U.nextFloat() * this.J - d1 * d3,
               this.q + this.U.nextFloat() * this.I * 2.0F - this.I - d2 * d3,
               d,
               d1,
               d2
            );
      }
   }

   @Override
   public void O() {
      super.O();
      this.ItemShears = this.bi;
      this.bi = 0.0F;
      this.M = 0.0F;
   }

   @Override
   public void a(double par1, double par3, double par5, float par7, float par8, int par9) {
      this.H = 0.0F;
      this.bW = par1;
      this.bX = par3;
      this.bY = par5;
      this.bZ = par7;
      this.IChunkProvider = par8;
      this.bV = par9;
   }

   @Override
   public void J_() {
      super.J_();
      if (this.bQ > 0) {
         if (this.bR <= 0) {
            this.bR = 60;
         }

         this.bR--;
         if (this.bR <= 0) {
            this.bQ--;
         }
      }

      this.e();
      double d = this.o - this.l;
      double d1 = this.q - this.n;
      float f = MathHelper.a(d * d + d1 * d1);
      float f1 = this.bd;
      float f2 = 0.0F;
      this.ItemShears = this.bi;
      float f3 = 0.0F;
      if (f > 0.05F) {
         f3 = 1.0F;
         f2 = f * 3.0F;
         f1 = (float)Math.atan2(d1, d) * 180.0F / (float) Math.PI - 90.0F;
      }

      if (this.bw > 0.0F) {
         f1 = this.u;
      }

      if (!this.z) {
         f3 = 0.0F;
      }

      this.bi = this.bi + (f3 - this.bi) * 0.3F;
      if (this.b_()) {
         this.aq.a();
      } else {
         float f4 = f1 - this.bd;

         while (f4 < -180.0F) {
            f4 += 360.0F;
         }

         while (f4 >= 180.0F) {
            f4 -= 360.0F;
         }

         this.bd += f4 * 0.3F;
         float f5 = this.u - this.bd;

         while (f5 < -180.0F) {
            f5 += 360.0F;
         }

         while (f5 >= 180.0F) {
            f5 -= 360.0F;
         }

         boolean flag = f5 < -90.0F || f5 >= 90.0F;
         if (f5 < -75.0F) {
            f5 = -75.0F;
         }

         if (f5 >= 75.0F) {
            f5 = 75.0F;
         }

         this.bd = this.u - f5;
         if (f5 * f5 > 2500.0F) {
            this.bd += f5 * 0.2F;
         }

         if (flag) {
            f2 *= -1.0F;
         }
      }

      while (this.u - this.w < -180.0F) {
         this.w -= 360.0F;
      }

      while (this.u - this.w >= 180.0F) {
         this.w += 360.0F;
      }

      while (this.bd - this.be < -180.0F) {
         this.be -= 360.0F;
      }

      while (this.bd - this.be >= 180.0F) {
         this.be += 360.0F;
      }

      while (this.v - this.x < -180.0F) {
         this.x -= 360.0F;
      }

      while (this.v - this.x >= 180.0F) {
         this.x += 360.0F;
      }

      while (this.WorldGenSwamp - this.bg < -180.0F) {
         this.bg -= 360.0F;
      }

      while (this.WorldGenSwamp - this.bg >= 180.0F) {
         this.bg += 360.0F;
      }

      this.EntityPotion += f2;
   }

   @Override
   protected void a(float par1, float par2) {
      super.a(par1, par2);
   }

   public void k(int par1) {
      if (this.bx > 0) {
         this.bx += par1;
         if (this.bx > this.d()) {
            this.bx = this.d();
         }

         this.Y = this.ba / 2;
      }
   }

   public abstract int d();

   public int ItemBucket() {
      return this.bx;
   }

   public void l(int par1) {
      this.bx = par1;
      if (par1 > this.d()) {
         par1 = this.d();
      }
   }

   @Override
   public boolean a(md par1DamageSource, int par2) {
      if (this.k.F) {
         return false;
      }

      this.cd = 0;
      if (this.bx <= 0) {
         return false;
      }

      if (par1DamageSource.k() && this.a(aad.n)) {
         return false;
      }

      this.bM = 1.5F;
      boolean flag = true;
      if (this.Y > this.ba / 2.0F) {
         if (par2 <= this.cc) {
            return false;
         }

         this.c(par1DamageSource, par2 - this.cc);
         this.cc = par2;
         flag = false;
      } else {
         this.cc = par2;
         this.by = this.bx;
         this.Y = this.ba;
         this.c(par1DamageSource, par2);
         this.bA = this.bB = 10;
      }

      this.bC = 0.0F;
      Entity entity = par1DamageSource.a();
      if (entity != null) {
         if (entity instanceof EntityLiving) {
            this.a((EntityLiving)entity);
         }

         if (entity instanceof EntityPlayer) {
            this.bP = 60;
            this.bO = (EntityPlayer)entity;
         } else if (entity instanceof yo) {
            yo entitywolf = (yo)entity;
            if (entitywolf.G_()) {
               this.bP = 60;
               this.bO = null;
            }
         }
      }

      if (flag) {
         this.k.a(this, (byte)2);
         this.K();
         if (entity != null) {
            double d = entity.o - this.o;

            double d1;
            for (d1 = entity.q - this.q; d * d + d1 * d1 < 1.0E-4; d1 = (Math.random() - Math.random()) * 0.01) {
               d = (Math.random() - Math.random()) * 0.01;
            }

            this.bC = (float)(Math.atan2(d1, d) * 180.0 / Math.PI) - this.u;
            this.a(entity, par2, d, d1);
         } else {
            this.bC = (int)(Math.random() * 2.0) * 180;
         }
      }

      if (this.bx <= 0) {
         if (flag) {
            this.k.a(this, this.o(), this.C_(), this.TileEntityMobSpawnerRenderer());
         }

         this.a(par1DamageSource);
      } else if (flag) {
         this.k.a(this, this.n(), this.C_(), this.TileEntityMobSpawnerRenderer());
      }

      return true;
   }

   private float TileEntityMobSpawnerRenderer() {
      return this.bi() ? (this.U.nextFloat() - this.U.nextFloat()) * 0.2F + 1.5F : (this.U.nextFloat() - this.U.nextFloat()) * 0.2F + 1.0F;
   }

   @Override
   public void k() {
      this.bA = this.bB = 10;
      this.bC = 0.0F;
   }

   public int au() {
      return 0;
   }

   protected void h(int i) {
   }

   protected int d(md par1DamageSource, int par2) {
      if (!par1DamageSource.e()) {
         int i = 25 - this.au();
         int j = par2 * i + this.EntityXPOrb;
         this.h(par2);
         par2 = j / 25;
         this.EntityXPOrb = j % 25;
      }

      return par2;
   }

   protected int b(md par1DamageSource, int par2) {
      if (this.a(aad.m)) {
         int i = (this.b(aad.m).c() + 1) * 5;
         int j = 25 - i;
         int k = par2 * j + this.EntityXPOrb;
         par2 = k / 25;
         this.EntityXPOrb = k % 25;
      }

      return par2;
   }

   protected void c(md par1DamageSource, int par2) {
      par2 = this.d(par1DamageSource, par2);
      par2 = this.b(par1DamageSource, par2);
      this.bx -= par2;
   }

   protected float C_() {
      return 1.0F;
   }

   protected String m() {
      return null;
   }

   protected String n() {
      return "damage.hurtflesh";
   }

   protected String o() {
      return "damage.hurtflesh";
   }

   public void a(Entity par1Entity, int par2, double par3, double par5) {
      this.BlockPortal = true;
      float f = MathHelper.a(par3 * par3 + par5 * par5);
      float f1 = 0.4F;
      this.r /= 2.0;
      this.s /= 2.0;
      this.t /= 2.0;
      this.r -= par3 / f * f1;
      this.s += f1;
      this.t -= par5 / f * f1;
      if (this.s > 0.4F) {
         this.s = 0.4F;
      }
   }

   public void a(md par1DamageSource) {
      Entity entity = par1DamageSource.a();
      if (this.br >= 0 && entity != null) {
         entity.a(this, this.br);
      }

      if (entity != null) {
         entity.b(this);
      }

      this.bH = true;
      if (!this.k.F) {
         int i = 0;
         if (entity instanceof EntityPlayer) {
            i = ais.f(((EntityPlayer)entity).ap);
         }

         if (!this.bi()) {
            this.a(this.bP > 0, i);
            if (this.bP > 0) {
               int j = this.U.nextInt(200) - i;
               if (j < 5) {
                  this.j_(j > 0 ? 0 : 1);
               }
            }
         }
      }

      this.k.a(this, (byte)3);
   }

   protected void j_(int i) {
   }

   protected void a(boolean par1, int par2) {
      int i = this.f();
      if (i > 0) {
         int j = this.U.nextInt(3);
         if (par2 > 0) {
            j += this.U.nextInt(par2 + 1);
         }

         for (int k = 0; k < j; k++) {
            this.b(i, 1);
         }
      }
   }

   protected int f() {
      return 0;
   }

   @Override
   protected void e(float par1) {
      super.e(par1);
      int i = (int)Math.ceil(par1 - 3.0F);
      if (i > 0) {
         if (i > 4) {
            this.k.a(this, "damage.fallbig", 1.0F, 1.0F);
         } else {
            this.k.a(this, "damage.fallsmall", 1.0F, 1.0F);
         }

         this.a(md.i, i);
         int j = this.k.getBlockId(MathHelper.d(this.o), MathHelper.c(this.p - 0.2F - this.H), MathHelper.d(this.q));
         if (j > 0) {
            vj stepsound = Block.m[j].cb;
            this.k.a(this, stepsound.d(), stepsound.b() * 0.5F, stepsound.c() * 0.75F);
         }
      }
   }

   public void a_(float par1, float par2) {
      if (this.H()) {
         double d = this.p;
         this.a((float)par1, (float)par2, this.b_() ? 0.04F : 0.02F);
         this.b(this.r, this.s, this.t);
         this.r *= 0.8F;
         this.s *= 0.8F;
         this.t *= 0.8F;
         this.s -= 0.02;
         if (this.A && this.e(this.r, this.s + 0.6F - this.p + d, this.t)) {
            this.s = 0.3F;
         }
      } else if (this.J()) {
         double d1 = this.p;
         this.a((float)par1, (float)par2, 0.02F);
         this.b(this.r, this.s, this.t);
         this.r *= 0.5;
         this.s *= 0.5;
         this.t *= 0.5;
         this.s -= 0.02;
         if (this.A && this.e(this.r, this.s + 0.6F - this.p + d1, this.t)) {
            this.s = 0.3F;
         }
      } else {
         float f = 0.91F;
         if (this.z) {
            f = 0.5460001F;
            int i = this.k.getBlockId(MathHelper.d(this.o), MathHelper.c(this.y.b) - 1, MathHelper.d(this.q));
            if (i > 0) {
               f = Block.m[i].ce * 0.91F;
            }
         }

         float f1 = 0.1627714F / (f * f * f);
         float f2;
         if (this.z) {
            if (this.b_()) {
               f2 = this.aS();
            } else {
               f2 = this.EntityFireball;
            }

            f2 *= f1;
         } else {
            f2 = this.bu;
         }

         this.a((float)par1, (float)par2, f2);
         f = 0.91F;
         if (this.z) {
            f = 0.5460001F;
            int j = this.k.getBlockId(MathHelper.d(this.o), MathHelper.c(this.y.b) - 1, MathHelper.d(this.q));
            if (j > 0) {
               f = Block.m[j].ce * 0.91F;
            }
         }

         if (this.p()) {
            float f3 = 0.15F;
            if (this.r < -f3) {
               this.r = -f3;
            }

            if (this.r > f3) {
               this.r = f3;
            }

            if (this.t < -f3) {
               this.t = -f3;
            }

            if (this.t > f3) {
               this.t = f3;
            }

            this.M = 0.0F;
            if (this.s < -0.15) {
               this.s = -0.15;
            }

            boolean flag = this.V() && this instanceof EntityPlayer;
            if (flag && this.s < 0.0) {
               this.s = 0.0;
            }
         }

         this.b(this.r, this.s, this.t);
         if (this.A && this.p()) {
            this.s = 0.2;
         }

         this.s -= 0.08;
         this.s *= 0.98F;
         this.r *= f;
         this.t *= f;
      }

      this.bL = this.bM;
      double d2 = this.o - this.l;
      double d3 = this.q - this.n;
      float f4 = MathHelper.a(d2 * d2 + d3 * d3) * 4.0F;
      if (f4 > 1.0F) {
         f4 = 1.0F;
      }

      this.bM = this.bM + (f4 - this.bM) * 0.4F;
      this.bN = this.bN + this.bM;
   }

   public boolean p() {
      long i = MathHelper.d(this.o);
      int j = MathHelper.c(this.y.b);
      long k = MathHelper.d(this.q);
      int l = this.k.getBlockId(i, j, k);
      return l == Block.aF.bO || l == Block.bu.bO;
   }

   @Override
   public void b(ady par1NBTTagCompound) {
      par1NBTTagCompound.a("Health", (short)this.bx);
      par1NBTTagCompound.a("HurtTime", (short)this.bA);
      par1NBTTagCompound.a("DeathTime", (short)this.bD);
      par1NBTTagCompound.a("AttackTime", (short)this.bE);
      if (!this.bS.isEmpty()) {
         no nbttaglist = new no();

         for (alg potioneffect : this.bS.values()) {
            ady nbttagcompound = new ady();
            nbttagcompound.a("Id", (byte)potioneffect.a());
            nbttagcompound.a("Amplifier", (byte)potioneffect.c());
            nbttagcompound.a("Duration", potioneffect.b());
            nbttaglist.a(nbttagcompound);
         }

         par1NBTTagCompound.a("ActiveEffects", nbttaglist);
      }
   }

   @Override
   public void a(ady par1NBTTagCompound) {
      if (this.bx < -32768) {
         this.bx = -32768;
      }

      this.bx = par1NBTTagCompound.e("Health");
      if (!par1NBTTagCompound.c("Health")) {
         this.bx = this.d();
      }

      this.bA = par1NBTTagCompound.e("HurtTime");
      this.bD = par1NBTTagCompound.e("DeathTime");
      this.bE = par1NBTTagCompound.e("AttackTime");
      if (par1NBTTagCompound.c("ActiveEffects")) {
         no nbttaglist = par1NBTTagCompound.n("ActiveEffects");

         for (int i = 0; i < nbttaglist.d(); i++) {
            ady nbttagcompound = (ady)nbttaglist.a(i);
            byte byte0 = nbttagcompound.d("Id");
            byte byte1 = nbttagcompound.d("Amplifier");
            int j = nbttagcompound.f("Duration");
            this.bS.put(Integer.valueOf(byte0), new alg(byte0, j, byte1));
         }
      }
   }

   @Override
   public boolean M() {
      return !this.G && this.bx > 0;
   }

   public boolean r_() {
      return false;
   }

   public void h(float par1) {
      this.cf = par1;
   }

   public void i(boolean par1) {
      this.ch = par1;
   }

   public void e() {
      if (this.EntityAIAttackOnCollide > 0) {
         this.EntityAIAttackOnCollide--;
      }

      if (this.bV > 0) {
         double d = this.o + (this.bW - this.o) / this.bV;
         double d1 = this.p + (this.bX - this.p) / this.bV;
         double d2 = this.q + (this.bY - this.q) / this.bV;
         double d3 = this.bZ - this.u;

         while (d3 < -180.0) {
            d3 += 360.0;
         }

         while (d3 >= 180.0) {
            d3 -= 360.0;
         }

         this.u = (float)(this.u + d3 / this.bV);
         this.v = (float)(this.v + (this.IChunkProvider - this.v) / this.bV);
         this.bV--;
         this.d(d, d1, d2);
         this.b(this.u, this.v);
         List list1 = this.k.a(this, this.y.e(0.03125, 0.0, 0.03125));
         if (list1.size() > 0) {
            double d4 = 0.0;

            for (int j = 0; j < list1.size(); j++) {
               AxisAlignedBB axisalignedbb = (AxisAlignedBB)list1.get(j);
               if (axisalignedbb.e > d4) {
                  d4 = axisalignedbb.e;
               }
            }

            d1 += d4 - this.y.b;
            this.d(d, d1, d2);
         }
      }

      lv.a("ai");
      if (this.aq()) {
         this.ch = false;
         this.ce = 0.0F;
         this.cf = 0.0F;
         this.cg = 0.0F;
      } else if (this.H_()) {
         if (this.b_()) {
            lv.a("newAi");
            this.s_();
            lv.b();
         } else {
            lv.a("oldAi");
            this.y_();
            lv.b();
            this.WorldGenSwamp = this.u;
         }
      }

      lv.b();
      boolean flag = this.H();
      boolean flag1 = this.J();
      if (this.ch) {
         if (flag) {
            this.s += 0.04F;
         } else if (flag1) {
            this.s += 0.04F;
         } else if (this.z && this.EntityAIAttackOnCollide == 0) {
            this.aD();
            this.EntityAIAttackOnCollide = 10;
         }
      } else {
         this.EntityAIAttackOnCollide = 0;
      }

      this.ce *= 0.98F;
      this.cf *= 0.98F;
      this.cg *= 0.9F;
      float f = this.EntityFireball;
      this.EntityFireball = this.EntityFireball * this.at();
      this.a_(this.ce, this.cf);
      this.EntityFireball = f;
      lv.a("push");
      List list = this.k.b(this, this.y.b(0.2F, 0.0, 0.2F));
      if (list != null && list.size() > 0) {
         for (int i = 0; i < list.size(); i++) {
            Entity entity = (Entity)list.get(i);
            if (entity.d_()) {
               entity.g(this);
            }
         }
      }

      lv.b();
   }

   protected boolean b_() {
      return false;
   }

   protected boolean H_() {
      return !this.k.F;
   }

   protected boolean aq() {
      return this.bx <= 0;
   }

   public boolean GenLayerHills() {
      return false;
   }

   protected void aD() {
      this.s = 0.42F;
      if (this.a(aad.j)) {
         this.s = this.s + (this.b(aad.j).c() + 1) * 0.1F;
      }

      if (this.W()) {
         float f = this.u * 0.01745329F;
         this.r = this.r - MathHelper.a(f) * 0.2F;
         this.t = this.t + MathHelper.b(f) * 0.2F;
      }

      this.BlockPortal = true;
   }

   protected boolean c_() {
      return true;
   }

   protected void w() {
      EntityPlayer entityplayer = this.k.a(this, -1.0);
      if (entityplayer != null) {
         double d = entityplayer.o - this.o;
         double d1 = entityplayer.p - this.p;
         double d2 = entityplayer.q - this.q;
         double d3 = d * d + d1 * d1 + d2 * d2;
         if (this.c_() && d3 > 16384.0) {
            this.A();
         }

         if (this.cd > 600 && this.U.nextInt(800) == 0 && d3 > 1024.0 && this.c_()) {
            this.A();
         } else if (d3 < 1024.0) {
            this.cd = 0;
         }
      }
   }

   protected void s_() {
      this.cd++;
      lv.a("checkDespawn");
      this.w();
      lv.b();
      lv.a("sensing");
      this.at.a();
      lv.b();
      lv.a("targetSelector");
      this.bU.a();
      lv.b();
      lv.a("goalSelector");
      this.bT.a();
      lv.b();
      lv.a("navigation");
      this.ar.d();
      lv.b();
      lv.a("mob tick");
      this.g();
      lv.b();
      lv.a("controls");
      this.GenLayerHills.c();
      this.MapGenVillage.a();
      this.ap.b();
      lv.b();
   }

   protected void g() {
   }

   protected void y_() {
      this.cd++;
      this.w();
      this.ce = 0.0F;
      this.cf = 0.0F;
      float f = 8.0F;
      if (this.U.nextFloat() < 0.02F) {
         EntityPlayer entityplayer = this.k.a(this, f);
         if (entityplayer != null) {
            this.StructureNetherBridgeStart = entityplayer;
            this.ThreadDownloadResources = 10 + this.U.nextInt(20);
         } else {
            this.cg = (this.U.nextFloat() - 0.5F) * 20.0F;
         }
      }

      if (this.StructureNetherBridgeStart != null) {
         this.a(this.StructureNetherBridgeStart, 10.0F, this.ak());
         if (this.ThreadDownloadResources-- <= 0 || this.StructureNetherBridgeStart.G || this.StructureNetherBridgeStart.f(this) > f * f) {
            this.StructureNetherBridgeStart = null;
         }
      } else {
         if (this.U.nextFloat() < 0.05F) {
            this.cg = (this.U.nextFloat() - 0.5F) * 20.0F;
         }

         this.u = this.u + this.cg;
         this.v = this.ci;
      }

      boolean flag = this.H();
      boolean flag1 = this.J();
      if (flag || flag1) {
         this.ch = this.U.nextFloat() < 0.8F;
      }
   }

   public int ak() {
      return 40;
   }

   public void a(Entity par1Entity, float par2, float par3) {
      double d = par1Entity.o - this.o;
      double d2 = par1Entity.q - this.q;
      double d1;
      if (par1Entity instanceof EntityLiving) {
         EntityLiving entityliving = (EntityLiving)par1Entity;
         d1 = this.p + this.I() - (entityliving.p + entityliving.I());
      } else {
         d1 = (par1Entity.y.b + par1Entity.y.e) / 2.0 - (this.p + this.I());
      }

      double d3 = MathHelper.a(d * d + d2 * d2);
      float f = (float)(Math.atan2(d2, d) * 180.0 / Math.PI) - 90.0F;
      float f1 = (float)(-(Math.atan2(d1, d3) * 180.0 / Math.PI));
      this.v = -this.b(this.v, f1, par3);
      this.u = this.b(this.u, f, par2);
   }

   private float b(float par1, float par2, float par3) {
      float f = par2 - par1;

      while (f < -180.0F) {
         f += 360.0F;
      }

      while (f >= 180.0F) {
         f -= 360.0F;
      }

      if (f > par3) {
         f = par3;
      }

      if (f < -par3) {
         f = -par3;
      }

      return par1 + f;
   }

   public void EntityAnimal() {
   }

   public boolean i() {
      return this.k.a(this.y) && this.k.a(this, this.y).size() == 0 && !this.k.b(this.y);
   }

   @Override
   protected void E() {
      this.a(md.j, 4);
   }

   public float i(float par1) {
      float f = this.bw - this.bv;
      if (f < 0.0F) {
         f++;
      }

      return this.bv + f * par1;
   }

   public bo j(float par1) {
      if (par1 == 1.0F) {
         return bo.b(this.o, this.p, this.q);
      }

      double d = this.l + (this.o - this.l) * par1;
      double d1 = this.m + (this.p - this.m) * par1;
      double d2 = this.n + (this.q - this.n) * par1;
      return bo.b(d, d1, d2);
   }

   @Override
   public bo Q() {
      return this.k(1.0F);
   }

   public bo k(float par1) {
      if (par1 == 1.0F) {
         float f = MathHelper.b(-this.u * 0.01745329F - (float) Math.PI);
         float f2 = MathHelper.a(-this.u * 0.01745329F - (float) Math.PI);
         float f4 = -MathHelper.b(-this.v * 0.01745329F);
         float f6 = MathHelper.a(-this.v * 0.01745329F);
         return bo.b(f2 * f4, f6, f * f4);
      } else {
         float f1 = this.x + (this.v - this.x) * par1;
         float f3 = this.w + (this.u - this.w) * par1;
         float f5 = MathHelper.b(-f3 * 0.01745329F - (float) Math.PI);
         float f7 = MathHelper.a(-f3 * 0.01745329F - (float) Math.PI);
         float f8 = -MathHelper.b(-f1 * 0.01745329F);
         float f9 = MathHelper.a(-f1 * 0.01745329F);
         return bo.b(f7 * f8, f9, f5 * f8);
      }
   }

   public float bd() {
      return 1.0F;
   }

   public MovingObjectPosition a(double par1, float par3) {
      bo vec3d = this.j(par3);
      bo vec3d1 = this.k(par3);
      bo vec3d2 = vec3d.c(vec3d1.a * par1, vec3d1.b * par1, vec3d1.c * par1);
      return this.k.a(vec3d, vec3d2);
   }

   public int EntityNoteFX() {
      return 4;
   }

   public ItemStack BlockTNT() {
      return null;
   }

   @Override
   public void a(byte par1) {
      if (par1 == 2) {
         this.bM = 1.5F;
         this.Y = this.ba;
         this.bA = this.bB = 10;
         this.bC = 0.0F;
         this.k.a(this, this.n(), this.C_(), (this.U.nextFloat() - this.U.nextFloat()) * 0.2F + 1.0F);
         this.a(md.k, 0);
      } else if (par1 == 3) {
         this.k.a(this, this.o(), this.C_(), (this.U.nextFloat() - this.U.nextFloat()) * 0.2F + 1.0F);
         this.bx = 0;
         this.a(md.k);
      } else {
         super.a(par1);
      }
   }

   public boolean TileEntityDispenser() {
      return false;
   }

   public int b(ItemStack par1ItemStack, int par2) {
      return par1ItemStack.b();
   }

   protected void be() {
      Iterator iterator = this.bS.keySet().iterator();

      while (iterator.hasNext()) {
         Integer integer = (Integer)iterator.next();
         alg potioneffect = (alg)this.bS.get(integer);
         if (!potioneffect.a(this) && !this.k.F) {
            iterator.remove();
            this.e(potioneffect);
         }
      }

      if (this.e) {
         if (!this.k.F) {
            if (!this.bS.isEmpty()) {
               int i = hx.a(this.bS.values());
               this.EntityNoteFX.b(8, i);
            } else {
               this.EntityNoteFX.b(8, 0);
            }
         }

         this.e = false;
      }

      if (this.U.nextBoolean()) {
         int j = this.EntityNoteFX.c(8);
         if (j > 0) {
            double d = (j >> 16 & 0xFF) / 255.0;
            double d1 = (j >> 8 & 0xFF) / 255.0;
            double d2 = (j >> 0 & 0xFF) / 255.0;
            this.k
               .a(
                  "mobSpell",
                  this.o + (this.U.nextDouble() - 0.5) * this.I,
                  this.p + this.U.nextDouble() * this.J - this.H,
                  this.q + (this.U.nextDouble() - 0.5) * this.I,
                  d,
                  d1,
                  d2
               );
         }
      }
   }

   public void WorldGenSwamp() {
      Iterator iterator = this.bS.keySet().iterator();

      while (iterator.hasNext()) {
         Integer integer = (Integer)iterator.next();
         alg potioneffect = (alg)this.bS.get(integer);
         if (!this.k.F) {
            iterator.remove();
            this.e(potioneffect);
         }
      }
   }

   public Collection bg() {
      return this.bS.values();
   }

   public boolean a(aad par1Potion) {
      return this.bS.containsKey(par1Potion.H);
   }

   public alg b(aad par1Potion) {
      return (alg)this.bS.get(par1Potion.H);
   }

   public void b(alg par1PotionEffect) {
      if (this.a(par1PotionEffect)) {
         if (this.bS.containsKey(par1PotionEffect.a())) {
            ((alg)this.bS.get(par1PotionEffect.a())).a(par1PotionEffect);
            this.d((alg)this.bS.get(par1PotionEffect.a()));
         } else {
            this.bS.put(par1PotionEffect.a(), par1PotionEffect);
            this.c(par1PotionEffect);
         }
      }
   }

   public boolean a(alg par1PotionEffect) {
      if (this.s() == bk.b) {
         int i = par1PotionEffect.a();
         if (i == aad.l.H || i == aad.u.H) {
            return false;
         }
      }

      return true;
   }

   public boolean ItemShears() {
      return this.s() == bk.b;
   }

   public void m(int par1) {
      this.bS.remove(par1);
   }

   protected void c(alg par1PotionEffect) {
      this.e = true;
   }

   protected void d(alg par1PotionEffect) {
      this.e = true;
   }

   protected void e(alg par1PotionEffect) {
      this.e = true;
   }

   protected float at() {
      float f = 1.0F;
      if (this.a(aad.c)) {
         f *= 1.0F + 0.2F * (this.b(aad.c).c() + 1);
      }

      if (this.a(aad.d)) {
         f *= 1.0F - 0.15F * (this.b(aad.d).c() + 1);
      }

      return f;
   }

   public void j(double par1, double par3, double par5) {
      this.c(par1, par3, par5, this.u, this.v);
   }

   public boolean bi() {
      return false;
   }

   public bk s() {
      return bk.a;
   }

   public void c(ItemStack par1ItemStack) {
      this.k.a(this, "random.break", 0.8F, 0.8F + this.k.r.nextFloat() * 0.4F);

      for (int i = 0; i < 5; i++) {
         bo vec3d = bo.b((this.U.nextFloat() - 0.5) * 0.1, Math.random() * 0.1 + 0.1, 0.0);
         vec3d.a(-this.v * (float) Math.PI / 180.0F);
         vec3d.b(-this.u * (float) Math.PI / 180.0F);
         bo vec3d1 = bo.b((this.U.nextFloat() - 0.5) * 0.3, -this.U.nextFloat() * 0.6 - 0.3, 0.6);
         vec3d1.a(-this.v * (float) Math.PI / 180.0F);
         vec3d1.b(-this.u * (float) Math.PI / 180.0F);
         vec3d1 = vec3d1.c(this.o, this.p + this.I(), this.q);
         this.k.a("iconcrack_" + par1ItemStack.a().bQ, vec3d1.a, vec3d1.b, vec3d1.c, vec3d.a, vec3d.b + 0.05, vec3d.c);
      }
   }
}
