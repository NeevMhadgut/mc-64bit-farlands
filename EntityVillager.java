public class EntityVillager extends ajr {
   private int b = 0;
   private boolean c = false;
   private boolean d = false;
   Village a = null;

   public EntityVillager(World par1World) {
      this(par1World, 0);
   }

   public EntityVillager(World par1World, int par2) {
      super(par1World);
      this.d_(par2);
      this.bm = "/mob/villager/villager.png";
      this.TileEntityMobSpawner = 0.5F;
      this.aM().b(true);
      this.aM().a(true);
      this.bT.a(0, new aje(this));
      this.bT.a(1, new fg(this, EntityZombie.class, 8.0F, 0.3F, 0.35F));
      this.bT.a(2, new EntityAIMoveIndoors(this));
      this.bT.a(3, new EntityAIRestrictOpenDoor(this));
      this.bT.a(4, new EntityAIOpenDoor(this, true));
      this.bT.a(5, new EntityAIMoveTwardsRestriction(this, 0.3F));
      this.bT.a(6, new EntityAIVillagerMate(this));
      this.bT.a(7, new yi(this));
      this.bT.a(8, new ux(this, 0.32F));
      this.bT.a(9, new vi(this, EntityPlayer.class, 3.0F, 1.0F));
      this.bT.a(9, new vi(this, EntityVillager.class, 5.0F, 0.02F));
      this.bT.a(9, new acu(this, 0.3F));
      this.bT.a(10, new ob(this, EntityLiving.class, 8.0F));
   }

   public boolean b_() {
      return true;
   }

   protected void g() {
      if (--this.b <= 0) {
         this.k.A.addVillagerPosition(MathHelper.d(this.o), MathHelper.c(this.p), MathHelper.d(this.q));
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

   protected void b() {
      super.b();
      this.EntityNoteFX.a(16, 0);
   }

   public int d() {
      return 20;
   }

   public void e() {
      super.e();
   }

   public void b(ady par1NBTTagCompound) {
      super.b(par1NBTTagCompound);
      par1NBTTagCompound.a("Profession", this.u());
   }

   public void a(ady par1NBTTagCompound) {
      super.a(par1NBTTagCompound);
      this.d_(par1NBTTagCompound.f("Profession"));
   }

   public String v_() {
      switch (this.u()) {
         case 0:
            return "/mob/villager/farmer.png";
         case 1:
            return "/mob/villager/librarian.png";
         case 2:
            return "/mob/villager/priest.png";
         case 3:
            return "/mob/villager/smith.png";
         case 4:
            return "/mob/villager/butcher.png";
         default:
            return super.v_();
      }
   }

   protected boolean c_() {
      return false;
   }

   protected String m() {
      return "mob.villager.default";
   }

   protected String n() {
      return "mob.villager.defaulthurt";
   }

   protected String o() {
      return "mob.villager.defaultdeath";
   }

   public void d_(int par1) {
      this.EntityNoteFX.b(16, par1);
   }

   public int u() {
      return this.EntityNoteFX.c(16);
   }

   public boolean x_() {
      return this.c;
   }

   public void a(boolean par1) {
      this.c = par1;
   }

   public void b(boolean par1) {
      this.d = par1;
   }

   public boolean x() {
      return this.d;
   }

   public void a(EntityLiving par1EntityLiving) {
      super.a(par1EntityLiving);
      if (this.a != null && par1EntityLiving != null) {
         this.a.a(par1EntityLiving);
      }
   }
}
