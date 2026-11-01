public class BlockFenceGate extends w {
   public BlockFenceGate(int par1, int par2) {
      super(par1, par2, acn.d);
   }

   public boolean canPlaceBlockAt(World par1World, long par2, int par3, long par4) {
      return !par1World.getBlockMaterial(par2, par3 - 1, par4).a() ? false : super.canPlaceBlockAt(par1World, par2, par3, par4);
   }

   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long par4) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      if (e(i)) {
         return null;
      } else {
         return i != 2 && i != 0
            ? AxisAlignedBB.b(par2 + 0.375, par3, par4, par2 + 0.625, par3 + 1.5, par4 + 1L)
            : AxisAlignedBB.b(par2, par3, par4 + 0.375, par2 + 1L, par3 + 1.5, par4 + 0.625);
      }
   }

   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      int i = a(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
      if (i != 2 && i != 0) {
         this.a(0.375F, 0.0F, 0.0F, 0.625F, 1.0F, 1.0F);
      } else {
         this.a(0.0F, 0.0F, 0.375F, 1.0F, 1.0F, 0.625F);
      }
   }

   public boolean a() {
      return false;
   }

   public boolean b() {
      return false;
   }

   public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      return e(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
   }

   public int d() {
      return 21;
   }

   public void onBlockPlacedBy(World par1World, long par2, int par3, long par4, EntityLiving par5EntityLiving) {
      int i = (MathHelper.c(par5EntityLiving.u * 4.0F / 360.0F + 0.5) & 3) % 4;
      par1World.setBlockMetadataWithNotify(par2, par3, par4, i);
   }

   public boolean blockActivated(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      if (e(i)) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, i & -5);
      } else {
         int j = (MathHelper.c(par5EntityPlayer.u * 4.0F / 360.0F + 0.5) & 3) % 4;
         int k = a(i);
         if (k == (j + 2) % 4) {
            i = j;
         }

         par1World.setBlockMetadataWithNotify(par2, par3, par4, i | 4);
      }

      par1World.playAuxSFXAtEntity(par5EntityPlayer, 1003, par2, par3, par4, 0);
      return true;
   }

   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      if (!par1World.F) {
         int i = par1World.getBlockMetadata(par2, par3, par4);
         boolean flag = par1World.isBlockIndirectlyGettingPowered(par2, par3, par4);
         if (flag || par5 > 0 && Block.m[par5].g() || par5 == 0) {
            if (flag && !e(i)) {
               par1World.setBlockMetadataWithNotify(par2, par3, par4, i | 4);
               par1World.playAuxSFXAtEntity(null, 1003, par2, par3, par4, 0);
            } else if (!flag && e(i)) {
               par1World.setBlockMetadataWithNotify(par2, par3, par4, i & -5);
               par1World.playAuxSFXAtEntity(null, 1003, par2, par3, par4, 0);
            }
         }
      }
   }

   public static boolean e(int par0) {
      return (par0 & 4) != 0;
   }
}
