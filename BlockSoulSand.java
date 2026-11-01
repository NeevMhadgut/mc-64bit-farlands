public class BlockSoulSand extends Block {
   public BlockSoulSand(int par1, int par2) {
      super(par1, par2, acn.o);
   }

   @Override
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long par4) {
      float f = 0.125F;
      return AxisAlignedBB.b(par2, par3, par4, par2 + 1L, par3 + 1 - f, par4 + 1L);
   }

   @Override
   public void onEntityCollidedWithBlock(World par1World, long par2, int par3, long par4, Entity par5Entity) {
      par5Entity.r *= 0.4;
      par5Entity.t *= 0.4;
   }
}
