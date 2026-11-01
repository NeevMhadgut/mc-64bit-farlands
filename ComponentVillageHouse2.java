import java.util.List;
import java.util.Random;

public class ComponentVillageHouse2 extends ComponentVillage {
   private static final fx[] a = new fx[]{
      new fx(Item.n.bQ, 0, 1, 3, 3),
      new fx(Item.o.bQ, 0, 1, 5, 10),
      new fx(Item.p.bQ, 0, 1, 3, 5),
      new fx(Item.U.bQ, 0, 1, 3, 15),
      new fx(Item.j.bQ, 0, 1, 3, 15),
      new fx(Item.g.bQ, 0, 1, 1, 5),
      new fx(Item.q.bQ, 0, 1, 1, 5),
      new fx(Item.BlockTNT.bQ, 0, 1, 1, 5),
      new fx(Item.ad.bQ, 0, 1, 1, 5),
      new fx(Item.TileEntityMobSpawnerRenderer.bQ, 0, 1, 1, 5),
      new fx(Item.ag.bQ, 0, 1, 1, 5),
      new fx(Block.ap.bO, 0, 3, 7, 5),
      new fx(Block.y.bO, 0, 3, 7, 5)
   };
   private int b = -1;
   private boolean c;

   public ComponentVillageHouse2(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.g = par3StructureBoundingBox;
   }

   @Override
   public void a(StructureComponent structurecomponent, List list, Random random) {
   }

   public static ComponentVillageHouse2 findValidPlacement(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, 0L, 0, 0L, 10L, 6, 7L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentVillageHouse2(par6, par1Random, structureboundingbox, par5) : null;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      if (this.b < 0) {
         this.b = this.b(par1World, par3StructureBoundingBox);
         if (this.b < 0) {
            return true;
         }

         this.g.offset(0L, this.b - this.g.e + 6 - 1, 0L);
      }

      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 1, 0L, 9L, 4, 6L, 0, 0, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 0, 0L, 9L, 0, 6L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 4, 0L, 9L, 4, 6L, Block.w.bO, Block.w.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 5, 0L, 9L, 5, 6L, Block.ak.bO, Block.ak.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 5, 1L, 8L, 5, 5L, 0, 0, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 1, 0L, 2L, 3, 0L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 1, 0L, 0L, 4, 0L, Block.J.bO, Block.J.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 3L, 1, 0L, 3L, 4, 0L, Block.J.bO, Block.J.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 1, 6L, 0L, 4, 6L, Block.J.bO, Block.J.bO, false);
      this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 3L, 3, 1L, par3StructureBoundingBox);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 3L, 1, 2L, 3L, 3, 2L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 1, 3L, 5L, 3, 3L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 1, 1L, 0L, 3, 5L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 1, 6L, 5L, 3, 6L, Block.x.bO, Block.x.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 5L, 1, 0L, 5L, 3, 0L, Block.aZ.bO, Block.aZ.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 9L, 1, 0L, 9L, 3, 0L, Block.aZ.bO, Block.aZ.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 6L, 1, 4L, 9L, 4, 6L, Block.w.bO, Block.w.bO, false);
      this.placeBlockAtCurrentPosition(par1World, Block.C.bO, 0, 7L, 1, 5L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.C.bO, 0, 8L, 1, 5L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.EntityAIMoveIndoors.bO, 0, 9L, 2, 5L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.EntityAIMoveIndoors.bO, 0, 9L, 2, 4L, par3StructureBoundingBox);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 7L, 2, 4L, 8L, 2, 5L, 0, 0, false);
      this.placeBlockAtCurrentPosition(par1World, Block.w.bO, 0, 6L, 1, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aB.bO, 0, 6L, 2, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aB.bO, 0, 6L, 3, 3L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aj.bO, 0, 8L, 1, 1L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 0L, 2, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 0L, 2, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 2L, 2, 6L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bq.bO, 0, 4L, 2, 6L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aZ.bO, 0, 2L, 1, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aM.bO, 0, 2L, 2, 4L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.x.bO, 0, 1L, 1, 5L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.at.bO, this.c(Block.at.bO, 3), 2L, 1, 5L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.at.bO, this.c(Block.at.bO, 1), 1L, 1, 4L, par3StructureBoundingBox);
      if (!this.c) {
         int i = this.b(1);
         long l = this.getXWithOffset(5L, 5L);
         long j1 = this.getZWithOffset(5L, 5L);
         if (par3StructureBoundingBox.isVecInside(l, i, j1)) {
            this.c = true;
            this.createTreasureChestAtCurrentPosition(par1World, par3StructureBoundingBox, par2Random, 5L, 1, 5L, a, 3 + par2Random.nextInt(6));
         }
      }

      for (int j = 6; j <= 8; j++) {
         if (this.getBlockIdAtCurrentPosition(par1World, j, 0, -1L, par3StructureBoundingBox) == 0
            && this.getBlockIdAtCurrentPosition(par1World, j, -1, -1L, par3StructureBoundingBox) != 0) {
            this.placeBlockAtCurrentPosition(par1World, Block.aH.bO, this.c(Block.aH.bO, 3), j, 0, -1L, par3StructureBoundingBox);
         }
      }

      for (int k = 0; k < 7; k++) {
         for (int i1 = 0; i1 < 10; i1++) {
            this.clearCurrentPositionBlocksUpwards(par1World, i1, 6, k, par3StructureBoundingBox);
            this.fillCurrentPositionBlocksDownwards(par1World, Block.w.bO, 0, i1, -1, k, par3StructureBoundingBox);
         }
      }

      this.spawnVillagers(par1World, par3StructureBoundingBox, 7L, 1, 1L, 1);
      return true;
   }

   @Override
   protected int a(int par1) {
      return 3;
   }
}
