import java.util.List;
import java.util.Random;

public class ComponentNetherBridgeStraight extends ComponentNetherBridgePiece {
   public ComponentNetherBridgeStraight(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.g = par3StructureBoundingBox;
   }

   @Override
   public void a(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
      this.a((ComponentNetherBridgeStartPiece)par1StructureComponent, par2List, par3Random, 1, 3, false);
   }

   public static ComponentNetherBridgeStraight createValidComponent(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -1L, -3, 0L, 5L, 10, 19L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentNetherBridgeStraight(par6, par1Random, structureboundingbox, par5) : null;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 3, 0L, 4L, 4, 18L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 5, 0L, 3L, 7, 18L, 0, 0, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 5, 0L, 0L, 5, 18L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 5, 0L, 4L, 5, 18L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 2, 0L, 4L, 2, 5L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 2, 13L, 4L, 2, 18L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 0, 0L, 4L, 1, 3L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 0, 15L, 4L, 1, 18L, Block.bA.bO, Block.bA.bO, false);

      for (int i = 0; i <= 4; i++) {
         for (int j = 0; j <= 2; j++) {
            this.fillCurrentPositionBlocksDownwards(par1World, Block.bA.bO, 0, i, -1, j, par3StructureBoundingBox);
            this.fillCurrentPositionBlocksDownwards(par1World, Block.bA.bO, 0, i, -1, 18 - j, par3StructureBoundingBox);
         }
      }

      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 1, 1L, 0L, 4, 1L, Block.bB.bO, Block.bB.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 3, 4L, 0L, 4, 4L, Block.bB.bO, Block.bB.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 3, 14L, 0L, 4, 14L, Block.bB.bO, Block.bB.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 1, 17L, 0L, 4, 17L, Block.bB.bO, Block.bB.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 1, 1L, 4L, 4, 1L, Block.bB.bO, Block.bB.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 3, 4L, 4L, 4, 4L, Block.bB.bO, Block.bB.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 3, 14L, 4L, 4, 14L, Block.bB.bO, Block.bB.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 1, 17L, 4L, 4, 17L, Block.bB.bO, Block.bB.bO, false);
      return true;
   }
}
