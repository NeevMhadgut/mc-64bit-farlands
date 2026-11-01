public class EntitySnowman extends akm {
   public EntitySnowman (World par1World) {
      super(par1World);
      this.bm = "/mob/snowman.png";
      this.a(0.4F, 1.8F);
      this.aM().a(true);
      this.bT.a(1, new sf(this, 0.25F, 2, 20));
      this.bT.a(2, new acu(this, 0.2F));
      this.bT.a(3, new ob(this, EntityPlayer.class, 6.0F));
      this.bT.a(4, new bd(this));
      this.bU.a(1, new amf(this, EntityMob.class, 16.0F, 0, true));
   }

   public boolean b_() {
      return true;
   }

   public int d() {
      return 4;
   }

   public void e() {
      super.e();
      if (this.G()) {
         this.a(md.f, 1);
      }

      long i = MathHelper.d(this.o);
      long k = MathHelper.d(this.q);
      if (this.k.getBiomeGenForCoords(i, k).j() > 1.0F) {
         this.a(md.c, 1);
      }

      for (int j = 0; j < 4; j++) {
         long l = MathHelper.d(this.o + (j % 2 * 2 - 1) * 0.25F);
         int i1 = MathHelper.c(this.p);
         long j1 = MathHelper.d(this.q + (j / 2 % 2 * 2 - 1) * 0.25F);
         if (this.k.getBlockId(l, i1, j1) == 0 && this.k.getBiomeGenForCoords(l, j1).j() < 0.8F && Block.aS.canPlaceBlockAt(this.k, l, i1, j1)) {
            this.k.setBlockWithNotify(l, i1, j1, Block.aS.bO);
         }
      }
   }

   public void b(ady par1NBTTagCompound) {
      super.b(par1NBTTagCompound);
   }

   public void a(ady par1NBTTagCompound) {
      super.a(par1NBTTagCompound);
   }

   protected int f() {
      return Item.aD.bQ;
   }

   protected void a(boolean par1, int par2) {
      int i = this.U.nextInt(16);

      for (int j = 0; j < i; j++) {
         this.b(Item.aD.bQ, 1);
      }
   }
}
