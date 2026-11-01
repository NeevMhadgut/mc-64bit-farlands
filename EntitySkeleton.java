public class EntitySkeleton extends EntityMob {
   private static final ItemStack a = new ItemStack(Item.k, 1);

   public EntitySkeleton(World par1World) {
      super(par1World);
      this.bm = "/mob/skeleton.png";
      this.TileEntityMobSpawner = 0.25F;
      this.bT.a(1, new aje(this));
      this.bT.a(2, new ajt(this));
      this.bT.a(3, new EntityAIFleeSun(this, this.TileEntityMobSpawner));
      this.bT.a(4, new sf(this, this.TileEntityMobSpawner, 1, 60));
      this.bT.a(5, new acu(this, this.TileEntityMobSpawner));
      this.bT.a(6, new ob(this, EntityPlayer.class, 8.0F));
      this.bT.a(6, new bd(this));
      this.bU.a(1, new zy(this, false));
      this.bU.a(2, new amf(this, EntityPlayer.class, 16.0F, 0, true));
   }

   @Override
   public boolean b_() {
      return true;
   }

   @Override
   public int d() {
      return 20;
   }

   @Override
   protected String m() {
      return "mob.skeleton";
   }

   @Override
   protected String n() {
      return "mob.skeletonhurt";
   }

   @Override
   protected String o() {
      return "mob.skeletonhurt";
   }

   @Override
   public ItemStack BlockTNT() {
      return a;
   }

   @Override
   public bk s() {
      return bk.b;
   }

   @Override
   public void e() {
      if (this.k.m() && !this.k.F) {
         float f = this.a(1.0F);
         if (f > 0.5F && this.k.canBlockSeeTheSky(MathHelper.d(this.o), MathHelper.c(this.p), MathHelper.d(this.q)) && this.U.nextFloat() * 30.0F < (f - 0.4F) * 2.0F) {
            this.e(8);
         }
      }

      super.e();
   }

   @Override
   public void a(md par1DamageSource) {
      super.a(par1DamageSource);
      if (par1DamageSource.b() instanceof EntityArrow && par1DamageSource.a() instanceof EntityPlayer) {
         EntityPlayer entityplayer = (EntityPlayer)par1DamageSource.a();
         double d = entityplayer.o - this.o;
         double d1 = entityplayer.q - this.q;
         if (d * d + d1 * d1 >= 2500.0) {
            entityplayer.a(dp.v);
         }
      }
   }

   @Override
   protected int f() {
      return Item.l.bQ;
   }

   @Override
   protected void a(boolean par1, int par2) {
      int i = this.U.nextInt(3 + par2);

      for (int j = 0; j < i; j++) {
         this.b(Item.l.bQ, 1);
      }

      i = this.U.nextInt(3 + par2);

      for (int k = 0; k < i; k++) {
         this.b(Item.aX.bQ, 1);
      }
   }

   @Override
   protected void j_(int par1) {
      if (par1 > 0) {
         ItemStack itemstack = new ItemStack(Item.k);
         ais.a(this.U, itemstack, 5);
         this.a(itemstack, 0.0F);
      } else {
         this.b(Item.k.bQ, 1);
      }
   }
}
