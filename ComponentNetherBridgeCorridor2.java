import java.util.List;
import java.util.Random;

public class ComponentNetherBridgeCorridor2 extends ComponentNetherBridgePiece {
   public ComponentNetherBridgeCorridor2(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.g = par3StructureBoundingBox;
   }

   @Override
   public void a(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
      this.c((ComponentNetherBridgeStartPiece)par1StructureComponent, par2List, par3Random, 0, 1, true);
   }

   public static ComponentNetherBridgeCorridor2 createValidComponent(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -1L, 0, 0L, 5L, 7, 5L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentNetherBridgeCorridor2(par6, par1Random, structureboundingbox, par5) : null;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 0, 0L, 4L, 1, 4L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 2, 0L, 4L, 5, 4L, 0, 0, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 2, 0L, 0L, 5, 4L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 3, 1L, 0L, 4, 1L, Block.bB.bO, Block.bB.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 3, 3L, 0L, 4, 3L, Block.bB.bO, Block.bB.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 2, 0L, 4L, 5, 0L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 2, 4L, 4L, 5, 4L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 3, 4L, 1L, 4, 4L, Block.bB.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 3L, 3, 4L, 3L, 4, 4L, Block.bB.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 6, 0L, 4L, 6, 4L, Block.bA.bO, Block.bA.bO, false);

      for (int i = 0; i <= 4; i++) {
         for (int j = 0; j <= 4; j++) {
            this.fillCurrentPositionBlocksDownwards(par1World, Block.bA.bO, 0, i, -1, j, par3StructureBoundingBox);
         }
      }

      return true;
   }
}
