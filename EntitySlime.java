public class EntitySlime extends EntityLiving implements xf {
   public float a;
   public float b;
   public float c;
   private int d = 0;

   public EntitySlime(World par1World) {
      super(par1World);
      this.bm = "/mob/slime.png";
      int i = 1 << this.U.nextInt(3);
      this.H = 0.0F;
      this.d = this.U.nextInt(20) + 10;
      this.d(i);
   }

   @Override
   protected void b() {
      super.b();
      this.EntityNoteFX.a(16, new Byte((byte)1));
   }

   public void d(int par1) {
      this.EntityNoteFX.b(16, new Byte((byte)par1));
      this.a(0.6F * par1, 0.6F * par1);
      this.d(this.o, this.p, this.q);
      this.l(this.d());
      this.bI = par1;
   }

   @Override
   public int d() {
      int i = this.ap();
      return i * i;
   }

   public int ap() {
      return this.EntityNoteFX.a(16);
   }

   @Override
   public void b(ady par1NBTTagCompound) {
      super.b(par1NBTTagCompound);
      par1NBTTagCompound.a("Size", this.ap() - 1);
   }

   @Override
   public void a(ady par1NBTTagCompound) {
      super.a(par1NBTTagCompound);
      this.d(par1NBTTagCompound.f("Size") + 1);
   }

   protected String TileEntityMobSpawnerRenderer() {
      return "slime";
   }

   protected String NoiseGeneratorPerlin() {
      return "mob.slime";
   }

   @Override
   public void J_() {
      if (!this.k.F && this.k.q == 0 && this.ap() > 0) {
         this.G = true;
      }

      this.b = this.b + (this.a - this.b) * 0.5F;
      this.c = this.b;
      boolean flag = this.z;
      super.J_();
      if (this.z && !flag) {
         int i = this.ap();

         for (int j = 0; j < i * 8; j++) {
            float f = this.U.nextFloat() * (float) Math.PI * 2.0F;
            float f1 = this.U.nextFloat() * 0.5F + 0.5F;
            float f2 = MathHelper.a(f) * i * 0.5F * f1;
            float f3 = MathHelper.b(f) * i * 0.5F * f1;
            this.k.a(this.TileEntityMobSpawnerRenderer(), this.o + f2, this.y.b, this.q + f3, 0.0, 0.0, 0.0);
         }

         if (this.MapGenVillage()) {
            this.k.a(this, this.NoiseGeneratorPerlin(), this.C_(), ((this.U.nextFloat() - this.U.nextFloat()) * 0.2F + 1.0F) / 0.8F);
         }

         this.a = -0.5F;
      }

      this.ai();
   }

   @Override
   protected void y_() {
      this.w();
      EntityPlayer entityplayer = this.k.b(this, 16.0);
      if (entityplayer != null) {
         this.a(entityplayer, 10.0F, 20.0F);
      }

      if (this.z && this.d-- <= 0) {
         this.d = this.ah();
         if (entityplayer != null) {
            this.d /= 3;
         }

         this.ch = true;
         if (this.ar()) {
            this.k.a(this, this.NoiseGeneratorPerlin(), this.C_(), ((this.U.nextFloat() - this.U.nextFloat()) * 0.2F + 1.0F) * 0.8F);
         }

         this.a = 1.0F;
         this.ce = 1.0F - this.U.nextFloat() * 2.0F;
         this.cf = 1 * this.ap();
      } else {
         this.ch = false;
         if (this.z) {
            this.ce = this.cf = 0.0F;
         }
      }
   }

   protected void ai() {
      this.a *= 0.6F;
   }

   protected int ah() {
      return this.U.nextInt(20) + 10;
   }

   protected EntitySlime ag() {
      return new EntitySlime(this.k);
   }

   @Override
   public void A() {
      int i = this.ap();
      if (!this.k.F && i > 1 && this.ItemBucket() <= 0) {
         int j = 2 + this.U.nextInt(3);

         for (int k = 0; k < j; k++) {
            float f = (k % 2 - 0.5F) * i / 4.0F;
            float f1 = (k / 2 - 0.5F) * i / 4.0F;
            EntitySlime entityslime = this.ag();
            entityslime.d(i / 2);
            entityslime.c(this.o + f, this.p + 0.5, this.q + f1, this.U.nextFloat() * 360.0F, 0.0F);
            this.k.a(entityslime);
         }
      }

      super.A();
   }

   @Override
   public void a(EntityPlayer par1EntityPlayer) {
      if (this.aj()) {
         int i = this.ap();
         if (this.m(par1EntityPlayer) && this.e(par1EntityPlayer) < 0.6 * i && par1EntityPlayer.a(md.a(this), this.BlockPortal())) {
            this.k.a(this, "mob.slimeattack", 1.0F, (this.U.nextFloat() - this.U.nextFloat()) * 0.2F + 1.0F);
         }
      }
   }

   protected boolean aj() {
      return this.ap() > 1;
   }

   protected int BlockPortal() {
      return this.ap();
   }

   @Override
   protected String n() {
      return "mob.slime";
   }

   @Override
   protected String o() {
      return "mob.slime";
   }

   @Override
   protected int f() {
      return this.ap() == 1 ? Item.aM.bQ : 0;
   }

   @Override
   public boolean i() {
      Chunk chunk = this.k.getChunkFromBlockCoords(MathHelper.d(this.o), MathHelper.d(this.q));
      return (this.ap() == 1 || this.k.q > 0) && this.U.nextInt(10) == 0 && chunk.a(987234911L).nextInt(10) == 0 && this.p < 40.0 ? super.i() : false;
   }

   @Override
   protected float C_() {
      return 0.4F * this.ap();
   }

   @Override
   public int ak() {
      return 0;
   }

   protected boolean ar() {
      return this.ap() > 1;
   }

   protected boolean MapGenVillage() {
      return this.ap() > 2;
   }
}
