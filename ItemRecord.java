import java.util.List;

public class ItemRecord extends Item {
   public final String a;

   protected ItemRecord(int par1, String par2Str) {
      super(par1);
      this.a = par2Str;
      this.bR = 1;
   }

   public boolean a(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7) {
      if (par3World.getBlockId(par4, par5, par6) != Block.aY.bO || par3World.getBlockMetadata(par4, par5, par6) != 0) {
         return false;
      }

      if (par3World.F) {
         return true;
      }

      ((BlockJukeBox)Block.aY).insertRecord(par3World, par4, par5, par6, this.bQ);
      par3World.playAuxSFXAtEntity(null, 1005, par4, par5, par6, this.bQ);
      par1ItemStack.a--;
      return true;
   }

   @Override
   public void a(ItemStack par1ItemStack, List par2List) {
      par2List.add("C418 - " + this.a);
   }

   @Override
   public fo f(ItemStack par1ItemStack) {
      return fo.c;
   }
}
