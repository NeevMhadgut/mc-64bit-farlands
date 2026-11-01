import java.util.ArrayList;
import java.util.Random;

public class BlockBrewingStand extends BlockContainer {
   private Random a = new Random();

   public BlockBrewingStand(int par1) {
      super(par1, acn.f);
      this.bN = 157;
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public int d() {
      return 25;
   }

   @Override
   public TileEntity u_() {
      return new TileEntityBrewingStand();
   }

   @Override
   public boolean b() {
      return false;
   }

   @Override
   public void getCollidingBoundingBoxes(World par1World, long par2, int par3, long par4, AxisAlignedBB par5AxisAlignedBB, ArrayList par6ArrayList) {
      this.a(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.875F, 0.5625F);
      super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
      this.h();
      super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
   }

   @Override
   public void h() {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
   }

   @Override
   public boolean blockActivated(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      if (par1World.F) {
         return true;
      }

      TileEntityBrewingStand tileentitybrewingstand = (TileEntityBrewingStand)par1World.getBlockTileEntity(par2, par3, par4);
      if (tileentitybrewingstand != null) {
         par5EntityPlayer.a(tileentitybrewingstand);
      }

      return true;
   }

   @Override
   public void randomDisplayTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      double d = par2 + 0.4 + par5Random.nextFloat() * 0.2F;
      double d1 = par3 + 0.7 + par5Random.nextFloat() * 0.3F;
      double d2 = par4 + 0.4 + par5Random.nextFloat() * 0.2F;
      par1World.a("smoke", d, d1, d2, 0.0, 0.0, 0.0);
   }

   @Override
   public void onBlockRemoval(World par1World, long par2, int par3, long par4) {
      TileEntity tileentity = par1World.getBlockTileEntity(par2, par3, par4);
      if (tileentity != null && tileentity instanceof TileEntityBrewingStand) {
         TileEntityBrewingStand tileentitybrewingstand = (TileEntityBrewingStand)tileentity;

         for (int i = 0; i < tileentitybrewingstand.a(); i++) {
            ItemStack itemstack = tileentitybrewingstand.k_(i);
            if (itemstack != null) {
               double f = this.a.nextFloat() * 0.8F + 0.1F;
               double f1 = this.a.nextFloat() * 0.8F + 0.1F;
               double f2 = this.a.nextFloat() * 0.8F + 0.1F;

               while (itemstack.a > 0) {
                  int j = this.a.nextInt(21) + 10;
                  if (j > itemstack.a) {
                     j = itemstack.a;
                  }

                  itemstack.a -= j;
                  EntityItem entityitem = new EntityItem(par1World, par2 + f, par3 + f1, par4 + f2, new ItemStack(itemstack.c, j, itemstack.i()));
                  float f3 = 0.05F;
                  entityitem.r = (float)this.a.nextGaussian() * f3;
                  entityitem.s = (float)this.a.nextGaussian() * f3 + 0.2F;
                  entityitem.t = (float)this.a.nextGaussian() * f3;
                  par1World.a(entityitem);
               }
            }
         }
      }

      super.onBlockRemoval(par1World, par2, par3, par4);
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return Item.by.bQ;
   }
}
