public class EntityOcelot extends wd {
   private akz b;

   public EntityOcelot(World par1World) {
      super(par1World);
      this.bm = "/mob/ozelot.png";
      this.a(0.6F, 0.8F);
      this.aM().a(true);
      this.bT.a(1, new aje(this));
      this.bT.a(2, this.a);
      this.bT.a(3, this.b = new akz(this, 0.18F, Item.aU.bQ, true));
      this.bT.a(4, new fg(this, EntityPlayer.class, 16.0F, 0.23F, 0.4F));
      this.bT.a(5, new EntityAIFollowOwner(this, 0.3F, 10.0F, 5.0F));
      this.bT.a(6, new x(this, 0.4F));
      this.bT.a(7, new bu(this, 0.3F));
      this.bT.a(8, new ut(this));
      this.bT.a(9, new als(this, 0.23F));
      this.bT.a(10, new acu(this, 0.23F));
      this.bT.a(11, new ob(this, EntityPlayer.class, 10.0F));
      this.bU.a(1, new aht(this, rd.class, 14.0F, 750, false));
   }

   protected void b() {
      super.b();
      this.EntityNoteFX.a(18, (byte)0);
   }

   public void g() {
      if (!this.aK().a()) {
         this.c(false);
         this.d(false);
      } else {
         float f = this.aK().b();
         if (f == 0.18F) {
            this.c(true);
            this.d(false);
         } else if (f == 0.4F) {
            this.c(false);
            this.d(true);
         } else {
            this.c(false);
            this.d(false);
         }
      }
   }

   protected boolean c_() {
      return !this.G_();
   }

   public String v_() {
      switch (this.ad()) {
         case 0:
            return "/mob/ozelot.png";
         case 1:
            return "/mob/cat_black.png";
         case 2:
            return "/mob/cat_red.png";
         case 3:
            return "/mob/cat_siamese.png";
         default:
            return super.v_();
      }
   }

   public boolean b_() {
      return true;
   }

   public int d() {
      return 10;
   }

   protected void e(float f) {
   }

   public void b(ady par1NBTTagCompound) {
      super.b(par1NBTTagCompound);
      par1NBTTagCompound.a("CatType", this.ad());
   }

   public void a(ady par1NBTTagCompound) {
      super.a(par1NBTTagCompound);
      this.c(par1NBTTagCompound.f("CatType"));
   }

   protected String m() {
      if (this.G_()) {
         if (this.o_()) {
            return "mob.cat.purr";
         } else {
            return this.U.nextInt(4) == 0 ? "mob.cat.purreow" : "mob.cat.meow";
         }
      } else {
         return "";
      }
   }

   protected String n() {
      return "mob.cat.hitt";
   }

   protected String o() {
      return "mob.cat.hitt";
   }

   protected float C_() {
      return 0.4F;
   }

   protected int f() {
      return Item.aF.bQ;
   }

   public boolean c(Entity par1Entity) {
      return par1Entity.a(md.a(this), 3);
   }

   public boolean a(md par1DamageSource, int par2) {
      this.a.a(false);
      return super.a(par1DamageSource, par2);
   }

   protected void a(boolean flag, int i) {
   }

   public boolean c(EntityPlayer par1EntityPlayer) {
      ItemStack itemstack = par1EntityPlayer.ap.b();
      if (!this.G_()) {
         if (this.b.h() && itemstack != null && itemstack.c == Item.aU.bQ && par1EntityPlayer.f(this) < 9.0) {
            itemstack.a--;
            if (itemstack.a <= 0) {
               par1EntityPlayer.ap.a(par1EntityPlayer.ap.c, null);
            }

            if (!this.k.F) {
               if (this.U.nextInt(3) == 0) {
                  this.b(true);
                  this.c(1 + this.k.r.nextInt(3));
                  this.a(par1EntityPlayer.aA);
                  this.a(true);
                  this.a.a(true);
                  this.k.a(this, (byte)7);
               } else {
                  this.a(false);
                  this.k.a(this, (byte)6);
               }
            }
         }

         return true;
      } else {
         if (par1EntityPlayer.aA.equalsIgnoreCase(this.ag()) && !this.k.F && !this.a(itemstack)) {
            this.a.a(!this.TileEntityMobSpawnerRenderer());
         }

         return super.c(par1EntityPlayer);
      }
   }

   public EntityAnimal a(EntityAnimal par1EntityAnimal) {
      EntityOcelot entityocelot = new EntityOcelot(this.k);
      if (this.G_()) {
         entityocelot.a(this.ag());
         entityocelot.b(true);
         entityocelot.c(this.ad());
      }

      return entityocelot;
   }

   public boolean a(ItemStack par1ItemStack) {
      return par1ItemStack != null && par1ItemStack.c == Item.aU.bQ;
   }

   public boolean b(EntityAnimal par1EntityAnimal) {
      if (par1EntityAnimal == this) {
         return false;
      }

      if (!this.G_()) {
         return false;
      }

      if (!(par1EntityAnimal instanceof EntityOcelot)) {
         return false;
      }

      EntityOcelot entityocelot = (EntityOcelot)par1EntityAnimal;
      return !entityocelot.G_() ? false : this.o_() && entityocelot.o_();
   }

   public int ad() {
      return this.EntityNoteFX.a(18);
   }

   public void c(int par1) {
      this.EntityNoteFX.b(18, (byte)par1);
   }

   public boolean i() {
      if (this.k.r.nextInt(3) == 0) {
         return false;
      }

      if (this.k.a(this.y) && this.k.a(this, this.y).size() == 0 && !this.k.b(this.y)) {
         long i = MathHelper.d(this.o);
         int j = MathHelper.c(this.y.b);
         long k = MathHelper.d(this.q);
         if (j < 63) {
            return false;
         }

         int l = this.k.getBlockId(i, j - 1, k);
         if (l == Block.u.bO || l == Block.K.bO) {
            return true;
         }
      }

      return false;
   }
}
