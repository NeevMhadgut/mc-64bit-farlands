public class EntityZombie extends EntityMob {
   public EntityZombie(World par1World) {
      super(par1World);
      this.bm = "/mob/zombie.png";
      this.TileEntityMobSpawner = 0.23F;
      this.c = 4;
      this.aM().b(true);
      this.bT.a(0, new aje(this));
      this.bT.a(1, new EntityAIBreakDoor(this));
      this.bT.a(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.TileEntityMobSpawner, false));
      this.bT.a(3, new EntityAIAttackOnCollide(this, EntityVillager.class, this.TileEntityMobSpawner, true));
      this.bT.a(4, new EntityAIMoveTwardsRestriction(this, this.TileEntityMobSpawner));
      this.bT.a(5, new EntityAIMoveThroughVillage(this, this.TileEntityMobSpawner, false));
      this.bT.a(6, new acu(this, this.TileEntityMobSpawner));
      this.bT.a(7, new ob(this, EntityPlayer.class, 8.0F));
      this.bT.a(7, new bd(this));
      this.bU.a(1, new zy(this, false));
      this.bU.a(2, new amf(this, EntityPlayer.class, 16.0F, 0, true));
      this.bU.a(2, new amf(this, EntityVillager.class, 16.0F, 0, false));
   }

   @Override
   public int d() {
      return 20;
   }

   @Override
   public int au() {
      return 2;
   }

   @Override
   protected boolean b_() {
      return true;
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
   protected String m() {
      return "mob.zombie";
   }

   @Override
   protected String n() {
      return "mob.zombiehurt";
   }

   @Override
   protected String o() {
      return "mob.zombiedeath";
   }

   @Override
   protected int f() {
      return Item.bm.bQ;
   }

   @Override
   public bk s() {
      return bk.b;
   }

   @Override
   protected void j_(int par1) {
      switch (this.U.nextInt(4)) {
         case 0:
            this.b(Item.q.bQ, 1);
            break;
         case 1:
            this.b(Item.ad.bQ, 1);
            break;
         case 2:
            this.b(Item.o.bQ, 1);
            break;
         case 3:
            this.b(Item.f.bQ, 1);
      }
   }
}
