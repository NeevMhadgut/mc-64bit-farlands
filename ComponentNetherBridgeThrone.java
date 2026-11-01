import java.util.List;
import java.util.Random;

public class ComponentNetherBridgeThrone extends ComponentNetherBridgePiece {
   private boolean a;

   public ComponentNetherBridgeThrone(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.g = par3StructureBoundingBox;
   }

   @Override
   public void a(StructureComponent structurecomponent, List list, Random random) {
   }

   public static ComponentNetherBridgeThrone createValidComponent(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -2L, 0, 0L, 7L, 8, 9L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentNetherBridgeThrone(par6, par1Random, structureboundingbox, par5) : null;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 2, 0L, 6L, 7, 7L, 0, 0, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 0, 0L, 5L, 1, 7L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 2, 1L, 5L, 2, 7L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 3, 2L, 5L, 3, 7L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 4, 3L, 5L, 4, 7L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 2, 0L, 1L, 4, 2L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 5L, 2, 0L, 5L, 4, 2L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 5, 2L, 1L, 5, 3L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 5L, 5, 2L, 5L, 5, 3L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 5, 3L, 0L, 5, 8L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 6L, 5, 3L, 6L, 5, 8L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 5, 8L, 5L, 5, 8L, Block.bA.bO, Block.bA.bO, false);
      this.placeBlockAtCurrentPosition(par1World, Block.bB.bO, 0, 1L, 6, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bB.bO, 0, 5L, 6, 3L, par3StructureBoundingBox);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 6, 3L, 0L, 6, 8L, Block.bB.bO, Block.bB.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 6L, 6, 3L, 6L, 6, 8L, Block.bB.bO, Block.bB.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 6, 8L, 5L, 7, 8L, Block.bB.bO, Block.bB.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 2L, 8, 8L, 4L, 8, 8L, Block.bB.bO, Block.bB.bO, false);
      if (!this.a) {
         int i = this.b(5);
         long k = this.getXWithOffset(3L, 5L);
         long i1 = this.getZWithOffset(3L, 5L);
         if (par3StructureBoundingBox.isVecInside(k, i, i1)) {
            this.a = true;
            par1World.setBlockWithNotify(k, i, i1, Block.as.bO);
            TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)par1World.getBlockTileEntity(k, i, i1);
            if (tileentitymobspawner != null) {
               tileentitymobspawner.a("Blaze");
            }
         }
      }

      for (int j = 0; j <= 6; j++) {
         for (int l = 0; l <= 6; l++) {
            this.fillCurrentPositionBlocksDownwards(par1World, Block.bA.bO, 0, j, -1, l, par3StructureBoundingBox);
         }
      }

      return true;
   }
}
