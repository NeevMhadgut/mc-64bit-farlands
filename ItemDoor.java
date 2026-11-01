public class ItemDoor extends Item {
   private acn a;

   public ItemDoor(int par1, acn par2Material) {
      super(par1);
      this.a = par2Material;
      this.bR = 1;
   }

   @Override
   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, long par4, int par5, long par6, int par7) {
      if (par7 != 1) {
         return false;
      }

      par5++;
      Block block;
      if (this.a == acn.d) {
         block = Block.aE;
      } else {
         block = Block.aL;
      }

      if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6) || !par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6)) {
         return false;
      }

      if (!block.canPlaceBlockAt(par3World, par4, par5, par6)) {
         return false;
      }

      int i = MathHelper.c((par2EntityPlayer.u + 180.0F) * 4.0F / 360.0F - 0.5) & 3;
      placeDoorBlock(par3World, par4, par5, par6, i, block);
      par1ItemStack.a--;
      return true;
   }

   public static void placeDoorBlock(World par0World, long par1, int par2, long par3, int par4, Block par5Block) {
      byte byte0 = 0;
      byte byte1 = 0;
      if (par4 == 0) {
         byte1 = 1;
      }

      if (par4 == 1) {
         byte0 = -1;
      }

      if (par4 == 2) {
         byte1 = -1;
      }

      if (par4 == 3) {
         byte0 = 1;
      }

      int i = (par0World.isBlockNormalCube(par1 - byte0, par2, par3 - byte1) ? 1 : 0)
         + (par0World.isBlockNormalCube(par1 - byte0, par2 + 1, par3 - byte1) ? 1 : 0);
      int j = (par0World.isBlockNormalCube(par1 + byte0, par2, par3 + byte1) ? 1 : 0)
         + (par0World.isBlockNormalCube(par1 + byte0, par2 + 1, par3 + byte1) ? 1 : 0);
      boolean flag = par0World.getBlockId(par1 - byte0, par2, par3 - byte1) == par5Block.bO
         || par0World.getBlockId(par1 - byte0, par2 + 1, par3 - byte1) == par5Block.bO;
      boolean flag1 = par0World.getBlockId(par1 + byte0, par2, par3 + byte1) == par5Block.bO
         || par0World.getBlockId(par1 + byte0, par2 + 1, par3 + byte1) == par5Block.bO;
      boolean flag2 = false;
      if (flag && !flag1) {
         flag2 = true;
      } else if (j > i) {
         flag2 = true;
      }

      par0World.o = true;
      par0World.setBlockAndMetadataWithNotify(par1, par2, par3, par5Block.bO, par4);
      par0World.setBlockAndMetadataWithNotify(par1, par2 + 1, par3, par5Block.bO, 8 | (flag2 ? 1 : 0));
      par0World.o = false;
      par0World.notifyBlocksOfNeighborChange(par1, par2, par3, par5Block.bO);
      par0World.notifyBlocksOfNeighborChange(par1, par2 + 1, par3, par5Block.bO);
   }
}
