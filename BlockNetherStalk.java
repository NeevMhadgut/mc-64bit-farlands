import java.util.Random;

public class BlockNetherStalk extends BlockFlower {
   protected BlockNetherStalk(int par1) {
      super(par1, 226);
      this.a(true);
      float f = 0.5F;
      this.a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
   }

   @Override
   protected boolean f_(int par1) {
      return par1 == Block.EntityAnimal.bO;
   }

   @Override
   public boolean canBlockStay(World par1World, long par2, int par3, long par4) {
      return this.f_(par1World.getBlockId(par2, par3 - 1, par4));
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      if (i < 3) {
         BiomeGenBase biomegenbase = par1World.getBiomeGenForCoords(par2, par4);
         if (biomegenbase instanceof BiomeGenHell && par5Random.nextInt(10) == 0) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, ++i);
         }
      }

      super.updateTick(par1World, par2, par3, par4, par5Random);
   }

   @Override
   public int a(int par1, int par2) {
      if (par2 >= 3) {
         return this.bN + 2;
      } else {
         return par2 > 0 ? this.bN + 1 : this.bN;
      }
   }

   @Override
   public int d() {
      return 6;
   }

   @Override
   public void dropBlockAsItemWithChance(World par1World, long par2, int par3, long par4, int par5, float par6, int par7) {
      if (!par1World.F) {
         int i = 1;
         if (par5 >= 3) {
            i = 2 + par1World.r.nextInt(3);
            if (par7 > 0) {
               i += par1World.r.nextInt(par7 + 1);
            }
         }

         for (int j = 0; j < i; j++) {
            this.dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(Item.br));
         }
      }
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return 0;
   }

   @Override
   public int a(Random par1Random) {
      return 0;
   }
}
