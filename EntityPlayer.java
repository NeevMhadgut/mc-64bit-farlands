import java.util.List;

public abstract class EntityPlayer extends EntityLiving {
   public aak ap = new aak(this);
   public dd aq;
   public dd ar;
   protected ne as = new ne();
   protected int at = 0;
   public byte au = 0;
   public int EntityThrowable = 0;
   public float aw;
   public float EntityAIAttackOnCollide;
   public boolean StructureNetherBridgeStart = false;
   public int TileEntityDispenser = 0;
   public String aA;
   public int aB;
   public String aC;
   public int aD = 0;
   public double aE;
   public double aF;
   public double aG;
   public double aH;
   public double aI;
   public double aJ;
   protected boolean aK;
   public ChunkCoordinates aL;
   private int a;
   public float aM;
   public float aN;
   public float aO;
   private ChunkCoordinates b;
   private ChunkCoordinates c;
   public int aP = 20;
   protected boolean aQ = false;
   public float aR;
   public float aS;
   public qu aT = new qu();
   public int aU;
   public int aV;
   public float aW;
   private ItemStack d;
   private int e;
   protected float aX = 0.1F;
   protected float aY = 0.02F;
   public EntityFishHook aZ = null;
   public int flySpeed;

   public EntityPlayer(World par1World) {
      super(par1World);
      this.aq = new y(this.ap, !par1World.F);
      this.ar = this.aq;
      this.H = 1.62F;
      ChunkCoordinates chunkcoordinates = par1World.x();
      this.c(chunkcoordinates.a + 0.5, chunkcoordinates.b + 1, chunkcoordinates.c + 0.5, 0.0F, 0.0F);
      this.EntityAIMoveIndoors = "humanoid";
      this.bo = 180.0F;
      this.W = 20;
      this.bm = "/mob/char.png";
      this.flySpeed = 1;
   }

   @Override
   public int d() {
      return 20;
   }

   @Override
   protected void b() {
      super.b();
      this.EntityNoteFX.a(16, (byte)0);
      this.EntityNoteFX.a(17, (byte)0);
   }

   public ItemStack ah() {
      return this.d;
   }

   public int ai() {
      return this.e;
   }

   public boolean aj() {
      return this.d != null;
   }

   public int BlockPortal() {
      return this.aj() ? this.d.l() - this.e : 0;
   }

   public void NoiseGeneratorPerlin() {
      if (this.d != null) {
         this.d.b(this.k, this, this.e);
      }

      this.MapGenVillage();
   }

   public void MapGenVillage() {
      this.d = null;
      this.e = 0;
      if (!this.k.F) {
         this.e(false);
      }
   }

   @Override
   public boolean GenLayerHills() {
      return this.aj() && Item.e[this.d.c].c(this.d) == aaq.d;
   }

   @Override
   public void J_() {
      if (this.d != null) {
         ItemStack itemstack = this.ap.b();
         if (itemstack != this.d) {
            this.MapGenVillage();
         } else {
            if (this.e <= 25 && this.e % 4 == 0) {
               this.a(itemstack, 5);
            }

            if (--this.e == 0 && !this.k.F) {
               this.ap();
            }
         }
      }

      if (this.aD > 0) {
         this.aD--;
      }

      if (this.TileEntityDispenser()) {
         this.a++;
         if (this.a > 100) {
            this.a = 100;
         }

         if (!this.k.F) {
            if (!this.bk()) {
               this.a(true, true, false);
            } else if (this.k.m()) {
               this.a(false, true, true);
            }
         }
      } else if (this.a > 0) {
         this.a++;
         if (this.a >= 110) {
            this.a = 0;
         }
      }

      super.J_();
      if (!this.k.F && this.ar != null && !this.ar.b(this)) {
         this.TileEntityMobSpawnerRenderer();
         this.ar = this.aq;
      }

      if (this.aT.b) {
         int i = 0;

         while (i < 8) {
            i++;
         }
      }

      if (this.T() && this.aT.a) {
         this.D();
      }

      this.aE = this.aH;
      this.aF = this.aI;
      this.aG = this.aJ;
      double d = this.o - this.aH;
      double d1 = this.p - this.aI;
      double d2 = this.q - this.aJ;
      double d3 = 10.0;
      if (d > d3) {
         this.aE = this.aH = this.o;
      }

      if (d2 > d3) {
         this.aG = this.aJ = this.q;
      }

      if (d1 > d3) {
         this.aF = this.aI = this.p;
      }

      if (d < -d3) {
         this.aE = this.aH = this.o;
      }

      if (d2 < -d3) {
         this.aG = this.aJ = this.q;
      }

      if (d1 < -d3) {
         this.aF = this.aI = this.p;
      }

      this.aH += d * 0.25;
      this.aJ += d2 * 0.25;
      this.aI += d1 * 0.25;
      this.a(gv.k, 1);
      if (this.j == null) {
         this.c = null;
      }

      if (!this.k.F) {
         this.as.a(this);
      }
   }

   protected void a(ItemStack par1ItemStack, int par2) {
      if (par1ItemStack.m() == aaq.c) {
         this.k.a(this, "random.drink", 0.5F, this.k.r.nextFloat() * 0.1F + 0.9F);
      }

      if (par1ItemStack.m() == aaq.b) {
         for (int i = 0; i < par2; i++) {
            bo vec3d = bo.b((this.U.nextFloat() - 0.5) * 0.1, Math.random() * 0.1 + 0.1, 0.0);
            vec3d.a(-this.v * (float) Math.PI / 180.0F);
            vec3d.b(-this.u * (float) Math.PI / 180.0F);
            bo vec3d1 = bo.b((this.U.nextFloat() - 0.5) * 0.3, -this.U.nextFloat() * 0.6 - 0.3, 0.6);
            vec3d1.a(-this.v * (float) Math.PI / 180.0F);
            vec3d1.b(-this.u * (float) Math.PI / 180.0F);
            vec3d1 = vec3d1.c(this.o, this.p + this.I(), this.q);
            this.k.a("iconcrack_" + par1ItemStack.a().bQ, vec3d1.a, vec3d1.b, vec3d1.c, vec3d.a, vec3d.b + 0.05, vec3d.c);
         }

         this.k.a(this, "random.eat", 0.5F + 0.5F * this.U.nextInt(2), (this.U.nextFloat() - this.U.nextFloat()) * 0.2F + 1.0F);
      }
   }

   protected void ap() {
      if (this.d != null) {
         this.a(this.d, 16);
         int i = this.d.a;
         ItemStack itemstack = this.d.b(this.k, this);
         if (itemstack != this.d || itemstack != null && itemstack.a != i) {
            this.ap.a[this.ap.c] = itemstack;
            if (itemstack.a == 0) {
               this.ap.a[this.ap.c] = null;
            }
         }

         this.MapGenVillage();
      }
   }

   @Override
   public void a(byte par1) {
      if (par1 == 9) {
         this.ap();
      } else {
         super.a(par1);
      }
   }

   @Override
   protected boolean aq() {
      return this.ItemBucket() <= 0 || this.TileEntityDispenser();
   }

   protected void TileEntityMobSpawnerRenderer() {
      this.ar = this.aq;
   }

   @Override
   public void S() {
      this.aC = "http://s3.amazonaws.com/MinecraftCloaks/" + this.aA + ".png";
      this.BlockSnowBlock = this.aC;
   }

   @Override
   public void O() {
      double d = this.o;
      double d1 = this.p;
      double d2 = this.q;
      super.O();
      this.aw = this.EntityAIAttackOnCollide;
      this.EntityAIAttackOnCollide = 0.0F;
      this.k(this.o - d, this.p - d1, this.q - d2);
   }

   @Override
   public void z() {
      this.H = 1.62F;
      this.a(0.6F, 1.8F);
      super.z();
      this.l(this.d());
      this.bD = 0;
   }

   private int EntityPotion() {
      if (this.a(aad.e)) {
         return 6 - (1 + this.b(aad.e).c()) * 1;
      } else {
         return this.a(aad.f) ? 6 + (1 + this.b(aad.f).c()) * 2 : 6;
      }
   }

   @Override
   protected void y_() {
      int i = this.EntityPotion();
      if (this.StructureNetherBridgeStart) {
         this.TileEntityDispenser++;
         if (this.TileEntityDispenser >= i) {
            this.TileEntityDispenser = 0;
            this.StructureNetherBridgeStart = false;
         }
      } else {
         this.TileEntityDispenser = 0;
      }

      this.bw = (float)this.TileEntityDispenser / i;
   }

   @Override
   public void e() {
      if (this.at > 0) {
         this.at--;
      }

      if (this.k.q == 0 && this.ItemBucket() < this.d() && this.V % 20 * 12 == 0) {
         this.k(1);
      }

      this.ap.g();
      this.aw = this.EntityAIAttackOnCollide;
      super.e();
      this.EntityFireball = this.aX;
      this.bu = this.aY;
      if (this.W()) {
         this.EntityFireball = (float)(this.EntityFireball + this.aX * 0.3);
         this.bu = (float)(this.bu + this.aY * 0.3);
      }

      float f = MathHelper.a(this.r * this.r + this.t * this.t);
      float f1 = (float)Math.atan(-this.s * 0.2F) * 15.0F;
      if (f > 0.1F) {
         f = 0.1F;
      }

      if (!this.z || this.ItemBucket() <= 0) {
         f = 0.0F;
      }

      if (this.z || this.ItemBucket() <= 0) {
         f1 = 0.0F;
      }

      this.EntityAIAttackOnCollide = this.EntityAIAttackOnCollide + (f - this.EntityAIAttackOnCollide) * 0.4F;
      this.bG = this.bG + (f1 - this.bG) * 0.8F;
      if (this.ItemBucket() > 0) {
         List list = this.k.b(this, this.y.b(1.0, 0.0, 1.0));
         if (list != null) {
            for (int i = 0; i < list.size(); i++) {
               Entity entity = (Entity)list.get(i);
               if (!entity.G) {
                  this.n(entity);
               }
            }
         }
      }
   }

   private void n(Entity par1Entity) {
      par1Entity.a(this);
   }

   public int ar() {
      return this.EntityThrowable;
   }

   @Override
   public void a(md par1DamageSource) {
      super.a(par1DamageSource);
      this.a(0.2F, 0.2F);
      this.d(this.o, this.p, this.q);
      this.s = 0.1F;
      if (this.aA.equals("314rft")) {
         this.a(new ItemStack(Item.at, 1), true);
      }

      this.ap.i();
      if (par1DamageSource != null) {
         this.r = -MathHelper.b((this.bC + this.u) * (float) Math.PI / 180.0F) * 0.1F;
         this.t = -MathHelper.a((this.bC + this.u) * (float) Math.PI / 180.0F) * 0.1F;
      } else {
         this.r = this.t = 0.0;
      }

      this.H = 0.1F;
      this.a(gv.y, 1);
   }

   @Override
   public void a(Entity par1Entity, int par2) {
      this.EntityThrowable += par2;
      if (par1Entity instanceof EntityPlayer) {
         this.a(gv.A, 1);
      } else {
         this.a(gv.z, 1);
      }
   }

   @Override
   protected int b(int par1) {
      int i = ais.a(this.ap);
      return (i <= 0 || this.U.nextInt(i + 1) <= 0) && !this.aT.a ? super.b(par1) : par1;
   }

   public EntityItem as() {
      return this.a(this.ap.a(this.ap.c, 1), false);
   }

   public EntityItem a(ItemStack par1ItemStack) {
      return this.a(par1ItemStack, false);
   }

   public EntityItem a(ItemStack par1ItemStack, boolean par2) {
      if (par1ItemStack == null) {
         return null;
      }

      EntityItem entityitem = new EntityItem(this.k, this.o, this.p - 0.3F + this.I(), this.q, par1ItemStack);
      entityitem.c = 40;
      float f = 0.1F;
      if (par2) {
         float f2 = this.U.nextFloat() * 0.5F;
         float f4 = this.U.nextFloat() * (float) Math.PI * 2.0F;
         entityitem.r = -MathHelper.a(f4) * f2;
         entityitem.t = MathHelper.b(f4) * f2;
         entityitem.s = 0.2F;
      } else {
         float f1 = 0.3F;
         entityitem.r = -MathHelper.a(this.u / 180.0F * (float) Math.PI) * MathHelper.b(this.v / 180.0F * (float) Math.PI) * f1;
         entityitem.t = MathHelper.b(this.u / 180.0F * (float) Math.PI) * MathHelper.b(this.v / 180.0F * (float) Math.PI) * f1;
         entityitem.s = -MathHelper.a(this.v / 180.0F * (float) Math.PI) * f1 + 0.1F;
         f1 = 0.02F;
         float f3 = this.U.nextFloat() * (float) Math.PI * 2.0F;
         f1 *= this.U.nextFloat();
         entityitem.r = entityitem.r + Math.cos(f3) * f1;
         entityitem.s = entityitem.s + (this.U.nextFloat() - this.U.nextFloat()) * 0.1F;
         entityitem.t = entityitem.t + Math.sin(f3) * f1;
      }

      this.a(entityitem);
      this.a(gv.v, 1);
      return entityitem;
   }

   protected void a(EntityItem par1EntityItem) {
      this.k.a(par1EntityItem);
   }

   public float a(Block par1Block) {
      float f = this.ap.a(par1Block);
      float f1 = f;
      int i = ais.b(this.ap);
      if (i > 0 && this.ap.b(par1Block)) {
         f1 += i * i + 1;
      }

      if (this.a(aad.e)) {
         f1 *= 1.0F + (this.b(aad.e).c() + 1) * 0.2F;
      }

      if (this.a(aad.f)) {
         f1 *= 1.0F - (this.b(aad.f).c() + 1) * 0.2F;
      }

      if (this.a(acn.g) && !ais.g(this.ap)) {
         f1 /= 5.0F;
      }

      if (!this.z) {
         f1 /= 5.0F;
      }

      return f1;
   }

   public boolean b(Block par1Block) {
      return this.ap.b(par1Block);
   }

   @Override
   public void a(ady par1NBTTagCompound) {
      super.a(par1NBTTagCompound);
      no nbttaglist = par1NBTTagCompound.n("Inventory");
      this.ap.b(nbttaglist);
      this.aB = par1NBTTagCompound.f("Dimension");
      this.aK = par1NBTTagCompound.o("Sleeping");
      this.a = par1NBTTagCompound.e("SleepTimer");
      this.aW = par1NBTTagCompound.h("XpP");
      this.aU = par1NBTTagCompound.f("XpLevel");
      this.aV = par1NBTTagCompound.f("XpTotal");
      if (this.aK) {
         this.aL = new ChunkCoordinates(MathHelper.d(this.o), MathHelper.c(this.p), MathHelper.d(this.q));
         this.a(true, true, false);
      }

      if (par1NBTTagCompound.c("SpawnX") && par1NBTTagCompound.c("SpawnY") && par1NBTTagCompound.c("SpawnZ")) {
         long leSpawnX;
         try {
            leSpawnX = par1NBTTagCompound.g("SpawnX");
         } catch (ClassCastException ex) {
            leSpawnX = par1NBTTagCompound.f("SpawnX");
         }

         long leSpawnZ;
         try {
            leSpawnZ = par1NBTTagCompound.g("SpawnZ");
         } catch (ClassCastException ex) {
            leSpawnZ = par1NBTTagCompound.f("SpawnZ");
         }

         this.b = new ChunkCoordinates(leSpawnX, par1NBTTagCompound.f("SpawnY"), leSpawnZ);
      }

      this.as.a(par1NBTTagCompound);
      this.aT.b(par1NBTTagCompound);
   }

   @Override
   public void b(ady par1NBTTagCompound) {
      super.b(par1NBTTagCompound);
      par1NBTTagCompound.a("Inventory", this.ap.a(new no()));
      par1NBTTagCompound.a("Dimension", this.aB);
      par1NBTTagCompound.a("Sleeping", this.aK);
      par1NBTTagCompound.a("SleepTimer", (short)this.a);
      par1NBTTagCompound.a("XpP", this.aW);
      par1NBTTagCompound.a("XpLevel", this.aU);
      par1NBTTagCompound.a("XpTotal", this.aV);
      if (this.b != null) {
         par1NBTTagCompound.a("SpawnX", this.b.a);
         par1NBTTagCompound.a("SpawnY", this.b.b);
         par1NBTTagCompound.a("SpawnZ", this.b.c);
      }

      this.as.b(par1NBTTagCompound);
      this.aT.a(par1NBTTagCompound);
   }

   public void a(io iinventory) {
   }

   public void displayGUIEnchantment(long i, int j, long k) {
   }

   public void displayWorkbenchGUI(long i, int j, long k) {
   }

   public void b(Entity entity, int i) {
   }

   @Override
   public float I() {
      return 0.12F;
   }

   protected void BlockSnowBlock() {
      this.H = 1.62F;
   }

   @Override
   public boolean a(md par1DamageSource, int par2) {
      if (this.aT.a && !par1DamageSource.g()) {
         return false;
      }

      this.cd = 0;
      if (this.ItemBucket() <= 0) {
         return false;
      }

      if (this.TileEntityDispenser() && !this.k.F) {
         this.a(true, true, false);
      }

      Entity entity = par1DamageSource.a();
      if (entity instanceof EntityMob || entity instanceof EntityArrow) {
         if (this.k.q == 0) {
            par2 = 0;
         }

         if (this.k.q == 1) {
            par2 = par2 / 2 + 1;
         }

         if (this.k.q == 3) {
            par2 = par2 * 3 / 2;
         }
      }

      if (par2 == 0) {
         return false;
      }

      Entity entity1 = entity;
      if (entity1 instanceof EntityArrow && ((EntityArrow)entity1).c != null) {
         entity1 = ((EntityArrow)entity1).c;
      }

      if (entity1 instanceof EntityLiving) {
         this.a((EntityLiving)entity1, false);
      }

      this.a(gv.x, par2);
      return super.a(par1DamageSource, par2);
   }

   @Override
   protected int b(md par1DamageSource, int par2) {
      int i = super.b(par1DamageSource, par2);
      if (i <= 0) {
         return 0;
      }

      int j = ais.a(this.ap, par1DamageSource);
      if (j > 20) {
         j = 20;
      }

      if (j > 0 && j <= 20) {
         int k = 25 - j;
         int l = i * k + this.EntityXPOrb;
         i = l / 25;
         this.EntityXPOrb = l % 25;
      }

      return i;
   }

   protected boolean B_() {
      return false;
   }

   protected void a(EntityLiving par1EntityLiving, boolean par2) {
      if (!(par1EntityLiving instanceof yd) && !(par1EntityLiving instanceof EntityGhast)) {
         if (par1EntityLiving instanceof yo) {
            yo entitywolf = (yo)par1EntityLiving;
            if (entitywolf.G_() && this.aA.equals(entitywolf.ag())) {
               return;
            }
         }

         if (!(par1EntityLiving instanceof EntityPlayer) || this.B_()) {
            for (Entity entity : this.k.a(yo.class, AxisAlignedBB.b(this.o, this.p, this.q, this.o + 1.0, this.p + 1.0, this.q + 1.0).b(16.0, 4.0, 16.0))) {
               yo entitywolf1 = (yo)entity;
               if (entitywolf1.G_() && entitywolf1.as() == null && this.aA.equals(entitywolf1.ag()) && (!par2 || !entitywolf1.TileEntityMobSpawnerRenderer())) {
                  entitywolf1.f(false);
                  entitywolf1.i(par1EntityLiving);
               }
            }
         }
      }
   }

   @Override
   protected void h(int par1) {
      this.ap.g(par1);
   }

   @Override
   public int au() {
      return this.ap.h();
   }

   @Override
   protected void c(md par1DamageSource, int par2) {
      if (!par1DamageSource.e() && this.GenLayerHills()) {
         par2 = 1 + par2 >> 1;
      }

      par2 = this.d(par1DamageSource, par2);
      par2 = this.b(par1DamageSource, par2);
      this.c(par1DamageSource.f());
      this.bx -= par2;
   }

   public void a(TileEntityFurnace tileentityfurnace) {
   }

   public void a(TileEntityDispenser tileentitydispenser) {
   }

   public void a(sc tileentitysign) {
   }

   public void a(TileEntityBrewingStand tileentitybrewingstand) {
   }

   public void j(Entity par1Entity) {
      if (!par1Entity.c(this)) {
         ItemStack itemstack = this.EntityThrowable();
         if (itemstack != null && par1Entity instanceof EntityLiving) {
            itemstack.a((EntityLiving)par1Entity);
            if (itemstack.a <= 0) {
               itemstack.a(this);
               this.aw();
            }
         }
      }
   }

   public ItemStack EntityThrowable() {
      return this.ap.b();
   }

   public void aw() {
      this.ap.a(this.ap.c, null);
   }

   @Override
   public double P() {
      return this.H - 0.5F;
   }

   public void EntityAIAttackOnCollide() {
      if (!this.StructureNetherBridgeStart || this.TileEntityDispenser >= this.EntityPotion() / 2 || this.TileEntityDispenser < 0) {
         this.TileEntityDispenser = -1;
         this.StructureNetherBridgeStart = true;
      }
   }

   public void k(Entity par1Entity) {
      if (par1Entity.k_()) {
         int i = this.ap.a(par1Entity);
         if (this.a(aad.g)) {
            i += 3 << this.b(aad.g).c();
         }

         if (this.a(aad.t)) {
            i -= 2 << this.b(aad.t).c();
         }

         int j = 0;
         int k = 0;
         if (par1Entity instanceof EntityLiving) {
            k = ais.a(this.ap, (EntityLiving)par1Entity);
            j += ais.b(this.ap, (EntityLiving)par1Entity);
         }

         if (this.W()) {
            j++;
         }

         if (i > 0 || k > 0) {
            boolean flag = this.M > 0.0F && !this.z && !this.p() && !this.H() && !this.a(aad.q) && this.j == null && par1Entity instanceof EntityLiving;
            if (flag) {
               i += this.U.nextInt(i / 2 + 2);
            }

            i += k;
            boolean flag1 = par1Entity.a(md.a(this), i);
            if (flag1) {
               if (j > 0) {
                  par1Entity.c(-MathHelper.a(this.u * (float) Math.PI / 180.0F) * j * 0.5F, 0.1, MathHelper.b(this.u * (float) Math.PI / 180.0F) * j * 0.5F);
                  this.r *= 0.6;
                  this.t *= 0.6;
                  this.d(false);
               }

               if (flag) {
                  this.d(par1Entity);
               }

               if (k > 0) {
                  this.i(par1Entity);
               }

               if (i >= 18) {
                  this.a(dp.E);
               }

               this.l(par1Entity);
            }

            ItemStack itemstack = this.EntityThrowable();
            if (itemstack != null && par1Entity instanceof EntityLiving) {
               itemstack.a((EntityLiving)par1Entity, this);
               if (itemstack.a <= 0) {
                  itemstack.a(this);
                  this.aw();
               }
            }

            if (par1Entity instanceof EntityLiving) {
               if (par1Entity.M()) {
                  this.a((EntityLiving)par1Entity, true);
               }

               this.a(gv.w, i);
               int l = ais.c(this.ap, (EntityLiving)par1Entity);
               if (l > 0) {
                  par1Entity.e(l * 4);
               }
            }

            this.c(0.3F);
         }
      }
   }

   public void d(Entity entity) {
   }

   public void i(Entity entity) {
   }

   public void ag() {
   }

   public abstract void ab();

   public void b(ItemStack itemstack) {
   }

   @Override
   public void A() {
      super.A();
      this.aq.a(this);
      if (this.ar != null) {
         this.ar.a(this);
      }
   }

   @Override
   public boolean N() {
      return !this.aK && super.N();
   }

   public ci sleepInBedAt(long par1, int par2, long par3) {
      if (!this.k.F) {
         if (this.TileEntityDispenser() || !this.M()) {
            return ci.e;
         }

         if (!this.k.t.e()) {
            return ci.b;
         }

         if (this.k.m()) {
            return ci.c;
         }

         if (Math.abs(this.o - par1) > 3.0 || Math.abs(this.p - par2) > 2.0 || Math.abs(this.q - par3) > 3.0) {
            return ci.d;
         }

         double d = 8.0;
         double d1 = 5.0;
         List list = this.k.a(EntityMob.class, AxisAlignedBB.b(par1 - d, par2 - d1, par3 - d, par1 + d, par2 + d1, par3 + d));
         if (!list.isEmpty()) {
            return ci.f;
         }
      }

      this.a(0.2F, 0.2F);
      this.H = 0.2F;
      if (this.k.blockExists(par1, par2, par3)) {
         int i = this.k.getBlockMetadata(par1, par2, par3);
         int j = BlockBed.a(i);
         double f = 0.5;
         double f1 = 0.5;
         switch (j) {
            case 0:
               f1 = 0.9;
               break;
            case 1:
               f = 0.1;
               break;
            case 2:
               f1 = 0.1;
               break;
            case 3:
               f = 0.9;
         }

         this.d(j);
         this.d(par1 + f, par2 + 0.9375, par3 + f1);
      } else {
         this.d(par1 + 0.5, par2 + 0.9375, par3 + 0.5);
      }

      this.aK = true;
      this.a = 0;
      this.aL = new ChunkCoordinates(par1, par2, par3);
      this.r = this.t = this.s = 0.0;
      if (!this.k.F) {
         this.k.C();
      }

      return ci.a;
   }

   private void d(int par1) {
      this.aM = 0.0F;
      this.aO = 0.0F;
      switch (par1) {
         case 0:
            this.aO = -1.8F;
            break;
         case 1:
            this.aM = 1.8F;
            break;
         case 2:
            this.aO = 1.8F;
            break;
         case 3:
            this.aM = -1.8F;
      }
   }

   public void a(boolean par1, boolean par2, boolean par3) {
      this.a(0.6F, 1.8F);
      this.BlockSnowBlock();
      ChunkCoordinates chunkcoordinates = this.aL;
      ChunkCoordinates chunkcoordinates1 = this.aL;
      if (chunkcoordinates != null && this.k.getBlockId(chunkcoordinates.a, chunkcoordinates.b, chunkcoordinates.c) == Block.S.bO) {
         BlockBed.setBedOccupied(this.k, chunkcoordinates.a, chunkcoordinates.b, chunkcoordinates.c, false);
         ChunkCoordinates chunkcoordinates2 = BlockBed.getNearestEmptyChunkCoordinates(this.k, chunkcoordinates.a, chunkcoordinates.b, chunkcoordinates.c, 0);
         if (chunkcoordinates2 == null) {
            chunkcoordinates2 = new ChunkCoordinates(chunkcoordinates.a, chunkcoordinates.b + 1, chunkcoordinates.c);
         }

         this.d(chunkcoordinates2.a + 0.5, (double)chunkcoordinates2.b + this.H + 0.1, chunkcoordinates2.c + 0.5);
      }

      this.aK = false;
      if (!this.k.F && par2) {
         this.k.C();
      }

      if (par1) {
         this.a = 0;
      } else {
         this.a = 100;
      }

      if (par3) {
         this.a(this.aL);
      }
   }

   private boolean bk() {
      return this.k.getBlockId(this.aL.a, this.aL.b, this.aL.c) == Block.S.bO;
   }

   public static ChunkCoordinates a(World par0World, ChunkCoordinates par1ChunkCoordinates) {
      IChunkProvider ichunkprovider = par0World.z();
      ichunkprovider.loadChunk(par1ChunkCoordinates.a - 3L >> 4, par1ChunkCoordinates.c - 3L >> 4);
      ichunkprovider.loadChunk(par1ChunkCoordinates.a + 3L >> 4, par1ChunkCoordinates.c - 3L >> 4);
      ichunkprovider.loadChunk(par1ChunkCoordinates.a - 3L >> 4, par1ChunkCoordinates.c + 3L >> 4);
      ichunkprovider.loadChunk(par1ChunkCoordinates.a + 3L >> 4, par1ChunkCoordinates.c + 3L >> 4);
      return par0World.getBlockId(par1ChunkCoordinates.a, par1ChunkCoordinates.b, par1ChunkCoordinates.c) != Block.S.bO
         ? null
         : BlockBed.getNearestEmptyChunkCoordinates(par0World, par1ChunkCoordinates.a, par1ChunkCoordinates.b, par1ChunkCoordinates.c, 0);
   }

   public float StructureNetherBridgeStart() {
      if (this.aL != null) {
         int i = this.k.getBlockMetadata(this.aL.a, this.aL.b, this.aL.c);
         int j = BlockBed.a(i);
         switch (j) {
            case 0:
               return 90.0F;
            case 1:
               return 0.0F;
            case 2:
               return 270.0F;
            case 3:
               return 180.0F;
         }
      }

      return 0.0F;
   }

   @Override
   public boolean TileEntityDispenser() {
      return this.aK;
   }

   public boolean aA() {
      return this.aK && this.a >= 100;
   }

   public int aB() {
      return this.a;
   }

   public void b(String s) {
   }

   public ChunkCoordinates aC() {
      return this.b;
   }

   public void a(ChunkCoordinates par1ChunkCoordinates) {
      if (par1ChunkCoordinates != null) {
         this.b = new ChunkCoordinates(par1ChunkCoordinates);
      } else {
         this.b = null;
      }
   }

   public void a(ajw par1StatBase) {
      this.a(par1StatBase, 1);
   }

   public void a(ajw statbase, int i) {
   }

   @Override
   protected void aD() {
      super.aD();
      this.a(gv.u, 1);
      if (this.W()) {
         this.c(0.8F);
      } else {
         this.c(0.2F);
      }
   }

   @Override
   public void a_(float par1, float par2) {
      double d = this.o;
      double d1 = this.p;
      double d2 = this.q;
      if (this.aT.b) {
         double d3 = this.s;
         float f = this.bu;
         this.bu = 0.075F * this.flySpeed * this.flySpeed;
         super.a_(par1, par2);
         this.s = d3 * 0.6;
         this.bu = f;
      } else {
         super.a_(par1, par2);
      }

      this.i(this.o - d, this.p - d1, this.q - d2);
   }

   public void i(double par1, double par3, double par5) {
      if (this.j == null) {
         if (this.a(acn.g)) {
            int i = Math.round(MathHelper.a(par1 * par1 + par3 * par3 + par5 * par5) * 100.0F);
            if (i > 0) {
               this.a(gv.q, i);
               this.c(0.015F * i * 0.01F);
            }
         } else if (this.H()) {
            int j = Math.round(MathHelper.a(par1 * par1 + par5 * par5) * 100.0F);
            if (j > 0) {
               this.a(gv.m, j);
               this.c(0.015F * j * 0.01F);
            }
         } else if (this.p()) {
            if (par3 > 0.0) {
               this.a(gv.o, (int)Math.round(par3 * 100.0));
            }
         } else if (this.z) {
            int k = Math.round(MathHelper.a(par1 * par1 + par5 * par5) * 100.0F);
            if (k > 0) {
               this.a(gv.l, k);
               if (this.W()) {
                  this.c(0.09999999F * k * 0.01F);
               } else {
                  this.c(0.01F * k * 0.01F);
               }
            }
         } else {
            int l = Math.round(MathHelper.a(par1 * par1 + par5 * par5) * 100.0F);
            if (l > 25) {
               this.a(gv.p, l);
            }
         }
      }
   }

   private void k(double par1, double par3, double par5) {
      if (this.j != null) {
         int i = Math.round(MathHelper.a(par1 * par1 + par3 * par3 + par5 * par5) * 100.0F);
         if (i > 0) {
            if (this.j instanceof EntityMinecart) {
               this.a(gv.r, i);
               if (this.c == null) {
                  this.c = new ChunkCoordinates(MathHelper.d(this.o), MathHelper.c(this.p), MathHelper.d(this.q));
               } else if (this.c.getEuclideanDistanceTo(MathHelper.d(this.o), MathHelper.c(this.p), MathHelper.d(this.q)) >= 1000.0) {
                  this.a(dp.q, 1);
               }
            } else if (this.j instanceof EntityBoat) {
               this.a(gv.s, i);
            } else if (this.j instanceof qr) {
               this.a(gv.t, i);
            }
         }
      }
   }

   @Override
   protected void e(float par1) {
      if (!this.aT.c) {
         if (par1 >= 2.0F) {
            this.a(gv.n, (int)Math.round(par1 * 100.0));
         }

         super.e(par1);
      }
   }

   @Override
   public void b(EntityLiving par1EntityLiving) {
      if (par1EntityLiving instanceof EntityMob) {
         this.a(dp.s);
      }
   }

   @Override
   public int b(ItemStack par1ItemStack, int par2) {
      int i = super.b(par1ItemStack, par2);
      if (par1ItemStack.c == Item.aR.bQ && this.aZ != null) {
         i = par1ItemStack.b() + 16;
      } else {
         if (par1ItemStack.a().c()) {
            return par1ItemStack.a().a(par1ItemStack.i(), par2);
         }

         if (this.d != null && par1ItemStack.c == Item.k.bQ) {
            int j = par1ItemStack.l() - this.e;
            if (j >= 18) {
               return 133;
            }

            if (j > 13) {
               return 117;
            }

            if (j > 0) {
               return 101;
            }
         }
      }

      return i;
   }

   @Override
   public void R() {
      if (this.aP > 0) {
         this.aP = 10;
      } else {
         this.aQ = true;
      }
   }

   public void i(int par1) {
      this.EntityThrowable += par1;
      int i = Integer.MAX_VALUE - this.aV;
      if (par1 > i) {
         par1 = i;
      }

      this.aW = this.aW + (float)par1 / this.aE();

      for (this.aV += par1; this.aW >= 1.0F; this.aW = this.aW / this.aE()) {
         this.aW = (this.aW - 1.0F) * this.aE();
         this.bl();
      }
   }

   public void j(int par1) {
      this.aU -= par1;
      if (this.aU < 0) {
         this.aU = 0;
      }
   }

   public int aE() {
      return 7 + (this.aU * 7 >> 1);
   }

   private void bl() {
      this.aU++;
   }

   public void c(float par1) {
      if (!this.aT.a) {
         if (!this.k.F) {
            this.as.a(par1);
         }
      }
   }

   public ne aF() {
      return this.as;
   }

   public boolean a(boolean par1) {
      return (par1 || this.as.c()) && !this.aT.a;
   }

   public boolean aG() {
      return this.ItemBucket() > 0 && this.ItemBucket() < this.d();
   }

   public void c(ItemStack par1ItemStack, int par2) {
      if (par1ItemStack != this.d) {
         this.d = par1ItemStack;
         this.e = par2;
         if (!this.k.F) {
            this.e(true);
         }
      }
   }

   public boolean canPlayerEdit(long par1, int par2, long par3) {
      return true;
   }

   @Override
   protected int b(EntityPlayer par1EntityPlayer) {
      int i = this.aU * 7;
      return i > 100 ? 100 : i;
   }

   @Override
   protected boolean aH() {
      return true;
   }

   public void c(int i) {
   }

   public void d(EntityPlayer par1EntityPlayer) {
      this.ap.a(par1EntityPlayer.ap);
      this.bx = par1EntityPlayer.bx;
      this.as = par1EntityPlayer.as;
      this.aU = par1EntityPlayer.aU;
      this.aV = par1EntityPlayer.aV;
      this.aW = par1EntityPlayer.aW;
      this.EntityThrowable = par1EntityPlayer.EntityThrowable;
   }

   @Override
   protected boolean e_() {
      return !this.aT.b;
   }

   public void aI() {
   }
}
