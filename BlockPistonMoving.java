import java.util.Random;

public class BlockPistonMoving extends BlockContainer {
   public BlockPistonMoving(int par1) {
      super(par1, acn.E);
      this.c(-1.0F);
   }

   @Override
   public TileEntity u_() {
      return null;
   }

   @Override
   public void onBlockAdded(World world, long i, int j, long k) {
   }

   @Override
   public void onBlockRemoval(World par1World, long par2, int par3, long par4) {
      TileEntity tileentity = par1World.getBlockTileEntity(par2, par3, par4);
      if (tileentity != null && tileentity instanceof TileEntityPiston) {
         ((TileEntityPiston)tileentity).g();
      } else {
         super.onBlockRemoval(par1World, par2, par3, par4);
      }
   }

   @Override
   public boolean canPlaceBlockAt(World par1World, long par2, int par3, long i) {
      return false;
   }

   @Override
   public boolean canPlaceBlockOnSide(World par1World, long par2, int par3, long i, int j) {
      return false;
   }

   @Override
   public int d() {
      return -1;
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public boolean b() {
      return false;
   }

   @Override
   public boolean blockActivated(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      if (!par1World.F && par1World.getBlockTileEntity(par2, par3, par4) == null) {
         par1World.setBlockWithNotify(par2, par3, par4, 0);
         return true;
      } else {
         return false;
      }
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return 0;
   }

   @Override
   public void dropBlockAsItemWithChance(World par1World, long par2, int par3, long par4, int par5, float par6, int par7) {
      if (!par1World.F) {
         TileEntityPiston tileentitypiston = this.getTileEntityAtLocation(par1World, par2, par3, par4);
         if (tileentitypiston != null) {
            Block.m[tileentitypiston.a()].dropBlockAsItem(par1World, par2, par3, par4, tileentitypiston.i(), 0);
         }
      }
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      if (!par1World.F && par1World.getBlockTileEntity(par2, par3, par4) != null) {
      }
   }

   public static TileEntity a(int par0, int par1, int par2, boolean par3, boolean par4) {
      return new TileEntityPiston(par0, par1, par2, par3, par4);
   }

   @Override
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long par4) {
      TileEntityPiston tileentitypiston = this.getTileEntityAtLocation(par1World, par2, par3, par4);
      if (tileentitypiston == null) {
         return null;
      }

      float f = tileentitypiston.a(0.0F);
      if (tileentitypiston.d()) {
         f = 1.0F - f;
      }

      return this.getAxisAlignedBB(par1World, par2, par3, par4, tileentitypiston.a(), f, tileentitypiston.e());
   }

   @Override
   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      TileEntityPiston tileentitypiston = this.getTileEntityAtLocation(par1IBlockAccess, par2, par3, par4);
      if (tileentitypiston != null) {
         Block block = Block.m[tileentitypiston.a()];
         if (block == null || block == this) {
            return;
         }

         block.setBlockBoundsBasedOnState(par1IBlockAccess, par2, par3, par4);
         float f = tileentitypiston.a(0.0F);
         if (tileentitypiston.d()) {
            f = 1.0F - f;
         }

         int i = tileentitypiston.e();
         this.bV = block.bV - qs.b[i] * f;
         this.bW = block.bW - qs.c[i] * f;
         this.bX = block.bX - qs.d[i] * f;
         this.bY = block.bY - qs.b[i] * f;
         this.bZ = block.bZ - qs.c[i] * f;
         this.IChunkProvider = block.IChunkProvider - qs.d[i] * f;
      }
   }

   public AxisAlignedBB getAxisAlignedBB(World par1World, long par2, int par3, long par4, int par5, float par6, int par7) {
      if (par5 != 0 && par5 != this.bO) {
         AxisAlignedBB axisalignedbb = Block.m[par5].getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
         if (axisalignedbb == null) {
            return null;
         }

         if (qs.b[par7] < 0) {
            axisalignedbb.a = axisalignedbb.a - qs.b[par7] * par6;
         } else {
            axisalignedbb.d = axisalignedbb.d - qs.b[par7] * par6;
         }

         if (qs.c[par7] < 0) {
            axisalignedbb.b = axisalignedbb.b - qs.c[par7] * par6;
         } else {
            axisalignedbb.e = axisalignedbb.e - qs.c[par7] * par6;
         }

         if (qs.d[par7] < 0) {
            axisalignedbb.c = axisalignedbb.c - qs.d[par7] * par6;
         } else {
            axisalignedbb.f = axisalignedbb.f - qs.d[par7] * par6;
         }

         return axisalignedbb;
      } else {
         return null;
      }
   }

   private TileEntityPiston getTileEntityAtLocation(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      TileEntity tileentity = par1IBlockAccess.getBlockTileEntity(par2, par3, par4);
      return tileentity != null && tileentity instanceof TileEntityPiston ? (TileEntityPiston)tileentity : null;
   }
}
