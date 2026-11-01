import java.util.List;
import java.util.Random;

public class ComponentVillageTorch extends ComponentVillage {
   private int a = -1;

   public ComponentVillageTorch(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.g = par3StructureBoundingBox;
   }

   @Override
   public void a(StructureComponent structurecomponent, List list, Random random) {
   }

   public static StructureBoundingBox findValidPlacement(List par0List, Random par1Random, long par2, int par3, long par4, int par5) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, 0L, 0, 0L, 3L, 4, 2L, par5);
      return StructureComponent.a(par0List, structureboundingbox) != null ? null : structureboundingbox;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      if (this.a < 0) {
         this.a = this.b(par1World, par3StructureBoundingBox);
         if (this.a < 0) {
            return true;
         }

         this.g.offset(0L, this.a - this.g.e + 4 - 1, 0L);
      }

      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 0, 0L, 2L, 3, 1L, 0, 0, false);
      this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 1L, 0, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 1L, 1, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 1L, 2, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.ab.bO, 15, 1L, 3, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 15, 0L, 3, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 15, 1L, 3, 1L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 15, 2L, 3, 0L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 15, 1L, 3, -1L, par3StructureBoundingBox);
      return true;
   }
}
