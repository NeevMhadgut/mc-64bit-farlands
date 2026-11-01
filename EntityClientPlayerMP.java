import net.minecraft.client.Minecraft;

public class EntityClientPlayerMP extends EntityPlayerSP {
   public NetClientHandler cl;
   private int cm = 0;
   private double co;
   private double cp;
   private double ComponentVillageHouse2;
   private double cr;
   private float WorldGenLakes;
   private float WorldRenderer;
   private boolean cu = false;
   private boolean cv = false;
   private boolean EffectRenderer = false;
   private int BlockLadder = 0;
   private boolean cn = false;

   public EntityClientPlayerMP(Minecraft par1Minecraft, World par2World, fc par3Session, NetClientHandler par4NetClientHandler) {
      super(par1Minecraft, par2World, par3Session, 0);
      this.cl = par4NetClientHandler;
   }

   @Override
   public boolean a(md par1DamageSource, int par2) {
      return false;
   }

   @Override
   public void k(int i) {
   }

   @Override
   public void J_() {
      if (this.k.blockExists(MathHelper.d(this.o), 0, MathHelper.d(this.q))) {
         super.J_();
         this.EntityPotion();
      }
   }

   public void EntityPotion() {
      if (this.cm++ == 20) {
         this.cm = 0;
      }

      boolean flag = this.W();
      if (flag != this.EffectRenderer) {
         if (flag) {
            this.cl.c(new aig(this, 4));
         } else {
            this.cl.c(new aig(this, 5));
         }

         this.EffectRenderer = flag;
      }

      boolean flag1 = this.V();
      if (flag1 != this.cv) {
         if (flag1) {
            this.cl.c(new aig(this, 1));
         } else {
            this.cl.c(new aig(this, 2));
         }

         this.cv = flag1;
      }

      double d = this.o - this.co;
      double d1 = this.y.b - this.cp;
      double d2 = this.p - this.ComponentVillageHouse2;
      double d3 = this.q - this.cr;
      double d4 = this.u - this.WorldGenLakes;
      double d5 = this.v - this.WorldRenderer;
      boolean flag2 = d1 != 0.0 || d2 != 0.0 || d != 0.0 || d3 != 0.0;
      boolean flag3 = d4 != 0.0 || d5 != 0.0;
      if (this.j != null) {
         if (flag3) {
            this.cl.c(new ag(this.r, -999.0, -999.0, this.t, this.z));
         } else {
            this.cl.c(new du(this.r, -999.0, -999.0, this.t, this.u, this.v, this.z));
         }

         flag2 = false;
      } else if (flag2 && flag3) {
         this.cl.c(new du(this.o, this.y.b, this.p, this.q, this.u, this.v, this.z));
         this.BlockLadder = 0;
      } else if (flag2) {
         this.cl.c(new ag(this.o, this.y.b, this.p, this.q, this.z));
         this.BlockLadder = 0;
      } else if (flag3) {
         this.cl.c(new pq(this.u, this.v, this.z));
         this.BlockLadder = 0;
      } else {
         this.cl.c(new gg(this.z));
         if (this.cu == this.z && this.BlockLadder <= 200) {
            this.BlockLadder++;
         } else {
            this.BlockLadder = 0;
         }
      }

      this.cu = this.z;
      if (flag2) {
         this.co = this.o;
         this.cp = this.y.b;
         this.ComponentVillageHouse2 = this.p;
         this.cr = this.q;
      }

      if (flag3) {
         this.WorldGenLakes = this.u;
         this.WorldRenderer = this.v;
      }
   }

   @Override
   public EntityItem as() {
      this.cl.c(new Packet14BlockDig(4, 0L, 0, 0L, 0));
      return null;
   }

   @Override
   protected void a(EntityItem entityitem) {
   }

   @Override
   public void a(String par1Str) {
      if (this.b.w.c().size() == 0 || !((String)this.b.w.c().get(this.b.w.c().size() - 1)).equals(par1Str)) {
         this.b.w.c().add(par1Str);
      }

      this.cl.c(new afd(par1Str));
   }

   @Override
   public void EntityAIAttackOnCollide() {
      super.EntityAIAttackOnCollide();
      this.cl.c(new kc(this, 1));
   }

   @Override
   public void ag() {
      this.cl.c(new kx(this.aB, (byte)this.k.q, this.k.B().t(), this.k.b(), 0));
   }

   @Override
   protected void c(md par1DamageSource, int par2) {
      this.l(this.ItemBucket() - par2);
   }

   @Override
   public void TileEntityMobSpawnerRenderer() {
      this.cl.c(new add(this.ar.f));
      this.ap.b(null);
      super.TileEntityMobSpawnerRenderer();
   }

   @Override
   public void d(int par1) {
      if (this.cn) {
         super.d(par1);
      } else {
         this.l(par1);
         this.cn = true;
      }
   }

   @Override
   public void a(ajw par1StatBase, int par2) {
      if (par1StatBase != null) {
         if (par1StatBase.f) {
            super.a(par1StatBase, par2);
         }
      }
   }

   public void b(ajw par1StatBase, int par2) {
      if (par1StatBase != null) {
         if (!par1StatBase.f) {
            super.a(par1StatBase, par2);
         }
      }
   }

   @Override
   public void aI() {
      this.cl.c(new ym(this.aT));
   }
}
