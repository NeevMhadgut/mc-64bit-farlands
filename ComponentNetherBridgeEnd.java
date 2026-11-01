import java.util.List;
import java.util.Random;

public class ComponentNetherBridgeEnd extends ComponentNetherBridgePiece {
   private int a;

   public ComponentNetherBridgeEnd(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.g = par3StructureBoundingBox;
      this.a = par2Random.nextInt();
   }

   @Override
   public void a(StructureComponent structurecomponent, List list, Random random) {
   }

   public static ComponentNetherBridgeEnd func_40023_a(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -1L, -3, 0L, 5L, 10, 8L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentNetherBridgeEnd(par6, par1Random, structureboundingbox, par5) : null;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      Random random = new Random(this.a);

      for (int i = 0; i <= 4; i++) {
         for (int i1 = 3; i1 <= 4; i1++) {
            int l1 = random.nextInt(8);
            this.fillWithBlocks(par1World, par3StructureBoundingBox, i, i1, 0L, i, i1, l1, Block.bA.bO, Block.bA.bO, false);
         }
      }

      int j = random.nextInt(8);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 5, 0L, 0L, 5, j, Block.bA.bO, Block.bA.bO, false);
      j = random.nextInt(8);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 5, 0L, 4L, 5, j, Block.bA.bO, Block.bA.bO, false);

      for (int k = 0; k <= 4; k++) {
         int j1 = random.nextInt(5);
         this.fillWithBlocks(par1World, par3StructureBoundingBox, k, 2, 0L, k, 2, j1, Block.bA.bO, Block.bA.bO, false);
      }

      for (int l = 0; l <= 4; l++) {
         for (int k1 = 0; k1 <= 1; k1++) {
            int i2 = random.nextInt(3);
            this.fillWithBlocks(par1World, par3StructureBoundingBox, l, k1, 0L, l, k1, i2, Block.bA.bO, Block.bA.bO, false);
         }
      }

      return true;
   }
}
