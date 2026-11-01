public class EntityIronGolem extends akm {
   private int b = 0;
   Village a = null;
   private int c;
   private int d;

   public EntityIronGolem(World par1World) {
      super(par1World);
      this.bm = "/mob/villager_golem.png";
      this.a(1.4F, 2.9F);
      this.aM().a(true);
      this.bT.a(1, new EntityAIAttackOnCollide(this, 0.25F, true));
      this.bT.a(2, new xz(this, 0.22F, 32.0F));
      this.bT.a(3, new EntityAIMoveThroughVillage(this, 0.16F, true));
      this.bT.a(4, new EntityAIMoveTwardsRestriction(this, 0.16F));
      this.bT.a(5, new yc(this));
      this.bT.a(6, new acu(this, 0.16F));
      this.bT.a(7, new ob(this, EntityPlayer.class, 6.0F));
      this.bT.a(8, new bd(this));
      this.bU.a(1, new hd(this));
      this.bU.a(2, new zy(this, false));
      this.bU.a(3, new amf(this, EntityMob.class, 16.0F, 0, false, true));
   }

   protected void b() {
      super.b();
      this.EntityNoteFX.a(16, (byte)0);
   }

   public boolean b_() {
      return true;
   }

   protected void g() {
      if (--this.b <= 0) {
         this.b = 70 + this.U.nextInt(50);
         this.a = this.k.A.findNearestVillage(MathHelper.d(this.o), MathHelper.c(this.p), MathHelper.d(this.q), 32);
         if (this.a == null) {
            this.aX();
         } else {
            ChunkCoordinates chunkcoordinates = this.a.a();
            this.setHomeArea(chunkcoordinates.a, chunkcoordinates.b, chunkcoordinates.c, this.a.b());
         }
      }

      super.g();
   }

   public int d() {
      return 100;
   }

   protected int b(int par1) {
      return par1;
   }

   public void e() {
      super.e();
      if (this.c > 0) {
         this.c--;
      }

      if (this.d > 0) {
         this.d--;
      }

      if (this.r * this.r + this.t * this.t > 2.5000003E-7F && this.U.nextInt(5) == 0) {
         long i = MathHelper.d(this.o);
         int j = MathHelper.c(this.p - 0.2F - this.H);
         long k = MathHelper.d(this.q);
         int l = this.k.getBlockId(i, j, k);
         int k1 = this.k.getBlockMetadata(i, j, k);
         if (l > 0) {
            this.k.stupidFuckingMethodSolelyForSprintingBecauseFuckMeIGuess(this, 1, i, j, k, l, k1);
         }
      }
   }

   public boolean a(Class par1Class) {
      return this.F_() && EntityPlayer.class.isAssignableFrom(par1Class) ? false : super.a(par1Class);
   }

   public void b(ady par1NBTTagCompound) {
      super.b(par1NBTTagCompound);
      par1NBTTagCompound.a("PlayerCreated", this.F_());
   }

   public void a(ady par1NBTTagCompound) {
      super.a(par1NBTTagCompound);
      this.b(par1NBTTagCompound.o("PlayerCreated"));
   }

   public boolean c(Entity par1Entity) {
      this.c = 10;
      this.k.a(this, (byte)4);
      boolean flag = par1Entity.a(md.a(this), 7 + this.U.nextInt(15));
      if (flag) {
         par1Entity.s += 0.4F;
      }

      this.k.a(this, "mob.irongolem.throw", 1.0F, 1.0F);
      return flag;
   }

   public void a(byte par1) {
      if (par1 == 4) {
         this.c = 10;
         this.k.a(this, "mob.irongolem.throw", 1.0F, 1.0F);
      } else if (par1 == 11) {
         this.d = 400;
      } else {
         super.a(par1);
      }
   }

   public Village BlockSnowBlock() {
      return this.a;
   }

   public int ab() {
      return this.c;
   }

   public void a(boolean par1) {
      this.d = par1 ? 400 : 0;
      this.k.a(this, (byte)11);
   }

   protected String m() {
      return "none";
   }

   protected String n() {
      return "mob.irongolem.hit";
   }

   protected String o() {
      return "mob.irongolem.death";
   }

   protected void playStepSound(long par1, int par2, long par3, int par4) {
      this.k.a(this, "mob.irongolem.walk", 1.0F, 1.0F);
   }

   protected void a(boolean par1, int par2) {
      int i = this.U.nextInt(3);

      for (int j = 0; j < i; j++) {
         this.b(Block.BlockTNT.bO, 1);
      }

      int k = 3 + this.U.nextInt(3);

      for (int l = 0; l < k; l++) {
         this.b(Item.o.bQ, 1);
      }
   }

   public int E_() {
      return this.d;
   }

   public boolean F_() {
      return (this.EntityNoteFX.a(16) & 1) != 0;
   }

   public void b(boolean par1) {
      byte byte0 = this.EntityNoteFX.a(16);
      if (par1) {
         this.EntityNoteFX.b(16, (byte)(byte0 | 1));
      } else {
         this.EntityNoteFX.b(16, (byte)(byte0 & -2));
      }
   }
}
