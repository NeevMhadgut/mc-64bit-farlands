import java.util.List;
import java.util.Random;

public class ComponentNetherBridgeCrossing3 extends ComponentNetherBridgePiece {
   public ComponentNetherBridgeCrossing3(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.g = par3StructureBoundingBox;
   }

   protected ComponentNetherBridgeCrossing3(Random par1Random, long par2, long par3) {
      super(0);
      this.h = par1Random.nextInt(4);
      switch (this.h) {
         case 0:
         case 2:
            this.g = new StructureBoundingBox(par2, 64, par3, par2 + 19L - 1L, 73, par3 + 19L - 1L);
            break;
         default:
            this.g = new StructureBoundingBox(par2, 64, par3, par2 + 19L - 1L, 73, par3 + 19L - 1L);
      }
   }

   @Override
   public void a(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
      this.a((ComponentNetherBridgeStartPiece)par1StructureComponent, par2List, par3Random, 8, 3, false);
      this.b((ComponentNetherBridgeStartPiece)par1StructureComponent, par2List, par3Random, 3, 8, false);
      this.c((ComponentNetherBridgeStartPiece)par1StructureComponent, par2List, par3Random, 3, 8, false);
   }

   public static ComponentNetherBridgeCrossing3 createValidComponent(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -8L, -3, 0L, 19L, 10, 19L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentNetherBridgeCrossing3(par6, par1Random, structureboundingbox, par5) : null;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 7L, 3, 0L, 11L, 4, 18L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 3, 7L, 18L, 4, 11L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 8L, 5, 0L, 10L, 7, 18L, 0, 0, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 5, 8L, 18L, 7, 10L, 0, 0, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 7L, 5, 0L, 7L, 5, 7L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 7L, 5, 11L, 7L, 5, 18L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 11L, 5, 0L, 11L, 5, 7L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 11L, 5, 11L, 11L, 5, 18L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 5, 7L, 7L, 5, 7L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 11L, 5, 7L, 18L, 5, 7L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 5, 11L, 7L, 5, 11L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 11L, 5, 11L, 18L, 5, 11L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 7L, 2, 0L, 11L, 2, 5L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 7L, 2, 13L, 11L, 2, 18L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 7L, 0, 0L, 11L, 1, 3L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 7L, 0, 15L, 11L, 1, 18L, Block.bA.bO, Block.bA.bO, false);

      for (int i = 7; i <= 11; i++) {
         for (int k = 0; k <= 2; k++) {
            this.fillCurrentPositionBlocksDownwards(par1World, Block.bA.bO, 0, i, -1, k, par3StructureBoundingBox);
            this.fillCurrentPositionBlocksDownwards(par1World, Block.bA.bO, 0, i, -1, 18 - k, par3StructureBoundingBox);
         }
      }

      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 2, 7L, 5L, 2, 11L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 13L, 2, 7L, 18L, 2, 11L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 0, 7L, 3L, 1, 11L, Block.bA.bO, Block.bA.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 15L, 0, 7L, 18L, 1, 11L, Block.bA.bO, Block.bA.bO, false);

      for (int j = 0; j <= 2; j++) {
         for (int l = 7; l <= 11; l++) {
            this.fillCurrentPositionBlocksDownwards(par1World, Block.bA.bO, 0, j, -1, l, par3StructureBoundingBox);
            this.fillCurrentPositionBlocksDownwards(par1World, Block.bA.bO, 0, 18 - j, -1, l, par3StructureBoundingBox);
         }
      }

      return true;
   }
}
