public abstract class EntityWaterMob extends EntityCreature {
   public EntityWaterMob(World par1World) {
      super(par1World);
   }

   @Override
   public boolean r_() {
      return false;
   }

   @Override
   public void b(ady par1NBTTagCompound) {
      super.b(par1NBTTagCompound);
   }

   @Override
   public void a(ady par1NBTTagCompound) {
      super.a(par1NBTTagCompound);
   }

   @Override
   public boolean i() {
      return false;
   }

   @Override
   public int j() {
      return 120;
   }

   @Override
   protected boolean c_() {
      return true;
   }

   @Override
   protected int b(EntityPlayer par1EntityPlayer) {
      return 1 + this.k.r.nextInt(3);
   }
}
