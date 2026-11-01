public class ItemBed extends Item {
   public ItemBed(int par1) {
      super(par1);
   }

   @Override
   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, long par4, int par5, long par6, int par7) {
      if (par7 != 1) {
         return false;
      }

      par5++;
      BlockBed blockbed = (BlockBed)Block.S;
      int i = MathHelper.c(par2EntityPlayer.u * 4.0F / 360.0F + 0.5) & 3;
      byte byte0 = 0;
      byte byte1 = 0;
      if (i == 0) {
         byte1 = 1;
      }

      if (i == 1) {
         byte0 = -1;
      }

      if (i == 2) {
         byte1 = -1;
      }

      if (i == 3) {
         byte0 = 1;
      }

      if (par2EntityPlayer.canPlayerEdit(par4, par5, par6) && par2EntityPlayer.canPlayerEdit(par4 + byte0, par5, par6 + byte1)) {
         if (par3World.isAirBlock(par4, par5, par6)
            && par3World.isAirBlock(par4 + byte0, par5, par6 + byte1)
            && par3World.isBlockNormalCube(par4, par5 - 1, par6)
            && par3World.isBlockNormalCube(par4 + byte0, par5 - 1, par6 + byte1)) {
            par3World.setBlockAndMetadataWithNotify(par4, par5, par6, blockbed.bO, i);
            if (par3World.getBlockId(par4, par5, par6) == blockbed.bO) {
               par3World.setBlockAndMetadataWithNotify(par4 + byte0, par5, par6 + byte1, blockbed.bO, i + 8);
            }

            par1ItemStack.a--;
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }
}
