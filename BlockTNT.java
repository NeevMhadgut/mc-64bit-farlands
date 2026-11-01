import java.util.Random;

public class BlockTNT extends Block {
   public BlockTNT(int par1, int par2) {
      super(par1, par2, acn.s);
   }

   @Override
   public int a_(int par1) {
      if (par1 == 0) {
         return this.bN + 2;
      } else {
         return par1 == 1 ? this.bN + 1 : this.bN;
      }
   }

   @Override
   public void onBlockAdded(World par1World, long par2, int par3, long par4) {
      super.onBlockAdded(par1World, par2, par3, par4);
      if (par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
         this.onBlockDestroyedByPlayer(par1World, par2, par3, par4, 1);
         par1World.setBlockWithNotify(par2, par3, par4, 0);
      }
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      if (par5 > 0 && Block.m[par5].g() && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
         this.onBlockDestroyedByPlayer(par1World, par2, par3, par4, 1);
         par1World.setBlockWithNotify(par2, par3, par4, 0);
      }
   }

   @Override
   public int a(Random par1Random) {
      return 0;
   }

   @Override
   public void onBlockDestroyedByExplosion(World par1World, long par2, int par3, long par4) {
      if (!par1World.F) {
         agg entitytntprimed = new agg(par1World, par2 + 0.5, par3 + 0.5, par4 + 0.5);
         entitytntprimed.a = par1World.r.nextInt(entitytntprimed.a / 4) + entitytntprimed.a / 8;
         par1World.a(entitytntprimed);
      }
   }

   @Override
   public void onBlockDestroyedByPlayer(World par1World, long par2, int par3, long par4, int par5) {
      if (!par1World.F) {
         if ((par5 & 1) == 0) {
            this.dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(Block.NoiseGeneratorPerlin.bO, 1, 0));
         } else {
            agg entitytntprimed = new agg(par1World, par2 + 0.5, par3 + 0.5, par4 + 0.5);
            par1World.a(entitytntprimed);
            par1World.a(entitytntprimed, "random.fuse", 1.0F, 1.0F);
         }
      }
   }

   @Override
   public void onBlockClicked(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      super.onBlockClicked(par1World, par2, par3, par4, par5EntityPlayer);
   }

   @Override
   public boolean blockActivated(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      if (par5EntityPlayer.EntityThrowable() != null && par5EntityPlayer.EntityThrowable().c == Item.i.bQ) {
         this.onBlockDestroyedByPlayer(par1World, par2, par3, par4, 1);
         par1World.setBlockWithNotify(par2, par3, par4, 0);
         return true;
      } else {
         return super.blockActivated(par1World, par2, par3, par4, par5EntityPlayer);
      }
   }

   @Override
   protected ItemStack b(int par1) {
      return null;
   }
}
